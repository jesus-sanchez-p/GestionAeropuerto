package GestionAeropuerto;

/**
 *
 * @author Jesús Sánchez Porras
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
       
    // Un avión de carga sólo requiere pista de precisión con mercancías peligrosas
    @Override
    public boolean requierePistaPrecision(){
        return mercanciasPeligrosas;
    }
    
}