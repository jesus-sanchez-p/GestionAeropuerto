package GestionAeropuerto;

/**
 *
 * @author Jes�s S�nchez Porras
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
    
    // Un avi�n de pasajeros siempre requiere pista de precisi�n
    @Override
    public boolean requierePistaPrecision(){
        return true;
    }
    
}