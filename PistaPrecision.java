package GestionAeropuerto;

/**
 *
 * @author Jes�s S�nchez Porras
 */

public class PistaPrecision extends Pista{
    
    // Atributos
    private String sistemasAyuda;
    
    //Constructor
    public PistaPrecision(String codigo, double longitudPista, double anchuraPista, String sistemasAyuda){
        super(codigo, longitudPista, anchuraPista);
        this.sistemasAyuda = sistemasAyuda;
    }
    
}