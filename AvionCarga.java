package GestionAeropuerto;

/**
 *
 * @author Jes�s S�nchez Porras
 */

public class AvionCarga extends Avion{
    
    // Atributos
    private boolean mercanciasPeligrosas;
    
    // Constructor
    public AvionCarga(String matricula, String compania, String modelo, boolean mercanciasPeligrosas){
        super(matricula, compania, modelo);
        this.mercanciasPeligrosas = mercanciasPeligrosas;
    }
    
    // Getter/setter
    public boolean getMercanciasPeligrosas(){
        return mercanciasPeligrosas;
    }
       
    // Un avi�n de carga s�lo requiere pista de precisi�n con mercanc�as peligrosas
    @Override
    public boolean requierePistaPrecision(){
        return mercanciasPeligrosas;
    }
    
}