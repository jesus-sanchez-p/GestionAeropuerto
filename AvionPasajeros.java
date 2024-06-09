package GestionAeropuerto;

/**
 *
 * @author Jesús Sánchez Porras
 */

public class AvionPasajeros extends Avion{
    
    // Atributos
    private int numeroPasajeros;
    
    // Constructor
    public AvionPasajeros(String matricula, String compania, String modelo, int numeroPasajeros){
        super(matricula, compania, modelo);
        this.numeroPasajeros = numeroPasajeros;
    }
    
    // Getter/setter
    public int getNumeroPasajeros(){
        return numeroPasajeros;
    }
    
    // Un avión de pasajeros siempre requiere pista de precisión
    @Override
    public boolean requierePistaPrecision(){
        return true;
    }
    
}