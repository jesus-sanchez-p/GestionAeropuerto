package GestionAeropuerto;

/**
 *
 * @author Jesús Sánchez Porras
 */

public class Pista{
   
    // Atributos
    private String codigo;
    private double longitudPista;
    private double anchuraPista;
    private int avionOcupando;
    
    // Constructor
    public Pista(String codigo, double longitudPista, double anchuraPista){
        this.codigo = codigo;
        this.longitudPista = longitudPista;
        this.anchuraPista = anchuraPista;
        this.avionOcupando = 0;
    }
    
    // Getter/setter
    public String getCodigo(){
        return codigo;
    }
    
    public int getAvionOcupando(){
        return avionOcupando;
    }
    
    // Métodos
    public void pistaOcupada(int avionOcupando){
        this.avionOcupando = avionOcupando;
    }
    
    public boolean pistaLibre(){
        return avionOcupando == 0;
    }
}