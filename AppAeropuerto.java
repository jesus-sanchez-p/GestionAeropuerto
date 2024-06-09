package GestionAeropuerto;

import java.util.Scanner;

/**
 *
 * @author Jesús Sánchez Porras
 */

public class AppAeropuerto{
    
    public static void main(String[] args){
        
        // Creamos el aeropuerto
        Aeropuerto aero1 = new Aeropuerto("Valencia-Manises","VLC");
        
        // Creamos varias pistas de ambos tipos
        aero1.nuevaPista(new Pista("Pista01", 425, 40));
        aero1.nuevaPista(new Pista("Pista02", 450, 45));
        aero1.nuevaPista(new PistaPrecision("Precision01", 500, 50, "Baliza simple"));
        aero1.nuevaPista(new PistaPrecision("Precision02", 600, 55, "Baliza extra"));
            
        // Lanzamos el menú de opciones
        do{
            menu();
            accion();
        }while (opcion != 7);
        
    }
    
    // Menú de opciones
    static int opcion;
    static Scanner scanner = new Scanner(System.in);

    public static void menu(){
        System.out.println("""
                           1) Aterrizaje de avión
                           2) Despegue de avión
                           3) Mostrar pistas libres
                           4) Grabar los datos de los aviones
                           5) Leer el archivo de datos
                           6) Añadir pista a la lista de pistas en funcionamiento
                           7) Borrar pista que entra en mantenimiento
                           ->
                           """);
        try{
            opcion = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            opcion = 0;
        }
    }
    
    public static void accion(){
        switch (opcion){
            case 1 -> aterrizaAvion();
            case 2 -> despegaAvion();
            case 3 -> muestraPistasLibres();
            case 4 -> grabaArchivo();
            case 5 -> leeArchivo();
            case 6 -> nuevaPista();
            case 7 -> quitaPista();
            default -> System.out.println("Opción errónea\n\n");
        }
    }
   
}

