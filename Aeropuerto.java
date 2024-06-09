package GestionAeropuerto;

import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jesús Sánchez Porras
 */

public class Aeropuerto{
    
    // Atributos
    private String nombre;
    private String codigo;
    private ArrayList<Pista> listaPistasFuncionando;
    private int codigoTemporalProvisional;
    private Map<String, Avion> registroAviones;
    
    // Constructor
    public Aeropuerto(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaPistasFuncionando = new ArrayList<>();
        this.codigoTemporalProvisional = 1;
        this.registroAviones = new HashMap<>();
    }
    
    // Getter/setter
    public ArrayList<Pista> getListaPistasFuncionando(){
        return listaPistasFuncionando;
    }
    
    // Métodos
    public void nuevaPista(Pista pista){
        listaPistasFuncionando.add(pista);
    }
    
    public void quitaPista(String codigo){
        listaPistasFuncionando.removeIf(pista -> pista.getCodigo().equals(codigo));
    }
    
    // Asignar código temporal a un avión
    public void registraAvion(Avion avion){
        avion.setCodigoTemporal(codigoTemporalProvisional++);
        registroAviones.put(avion.getMatricula(), avion);
    }
    
    // Un avión aterriza
    public boolean aterrizaAvion(Avion avion){
        // Si el avión necesita pista de precisión
        if (avion.requierePistaPrecision()){
            for (Pista pista : listaPistasFuncionando){
                if (pista instanceof PistaPrecision && pista.pistaLibre()){
                    pista.pistaOcupada(avion.getCodigoTemporal());
                    registraAvion(avion);
                    return true;
                }
            }
        }else{ // Si no necesita pista de precisión
            for (Pista pista : listaPistasFuncionando){
                if (pista.pistaLibre()){
                    pista.pistaOcupada(avion.getCodigoTemporal());
                    registraAvion(avion);
                    return true;
                }
            }
        }
        // No hay libre ninguna pista del tipo que necesite el avión
        return false;
    }
    
    // Un avión despega
    public boolean despegaAvion(int codigoTemporal){
        for (Pista pista : listaPistasFuncionando){
            if (pista.getAvionOcupando() == codigoTemporal){
                pista.pistaOcupada(0);
                registroAviones.values().removeIf(avion -> avion.getCodigoTemporal() == codigoTemporal);
                return true;
            }
        }
        // No hay ninguna pista ocupada con el avión especificado
        return false;
    }
    
    // Mostramos las pistas libres
    public void muestraPistasLibres(){
        for (Pista pista : listaPistasFuncionando){
            if (pista.pistaLibre()){
                System.out.println("Pista libre: " + pista.getCodigo());
            }
        }
    }
    
    // Guardamos los datos de los aviones que están actualmente en el aeropuerto
    public void grabaArchivo(String nombreArchivo){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))){
            for (Avion avion : registroAviones.values()){
                bw.write(avion.getMatricula() + ", " + avion.getCompania() + ", " + avion.getModelo() + ", " + avion.getCodigoTemporal());
                if (avion instanceof AvionPasajeros){
                    AvionPasajeros avionPasajeros = (AvionPasajeros) avion;
                    bw.write(", " + avionPasajeros.getNumeroPasajeros());
                }else if (avion instanceof AvionCarga){
                    AvionCarga avionCarga = (AvionCarga) avion;
                    bw.write(", " + avionCarga.getMercanciasPeligrosas());
                }
                bw.newLine();
            }
            System.out.println("Aviones registrados en el sistema");
        }catch (IOException e){
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }
    
    // Mostramos el estado actual del archivo
    public void leeArchivo(String nombreArchivo){
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] registro = linea.split(", ");
                String matricula = registro[0];
                String compania = registro[1];
                String modelo = registro[2];
                int codigoTemporal = Integer.parseInt(registro[3]);
                
                if (registro.length == 5){
                    int numeroPasajeros = Integer.parseInt(registro[4]);
                    AvionPasajeros avionPasajeros = new AvionPasajeros(matricula, compania, modelo, numeroPasajeros);
                    avionPasajeros.setCodigoTemporal(codigoTemporal);
                    registroAviones.put(matricula, avionPasajeros);
                }else if (registro.length == 5){
                    boolean mercanciasPeligrosas = Boolean.parseBoolean(registro[4]);
                    AvionCarga avionCarga = new AvionCarga(matricula, compania, modelo, mercanciasPeligrosas);
                    avionCarga.setCodigoTemporal(codigoTemporal);
                }
            }
            System.out.println("Registro de los datos de los aviones");
        }catch (IOException e){
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }

}