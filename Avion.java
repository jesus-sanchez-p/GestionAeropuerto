package GestionAeropuerto;

/**
 *
 * @author Jes�s S�nchez Porras
 */

public abstract class Avion{
   
    // Atributos
    private String matricula;
    private String compania;
    private String modelo;
    private int codigoTemporal;
    
    // Constructor
    public Avion(String matricula, String compania, String modelo){
        this.matricula = matricula;
        this.compania = compania;
        this.modelo = modelo;
    }
    
    // Getter/setter
    public String getMatricula(){
        return matricula;
    }
    
    public String getCompania(){
        return compania;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public int getCodigoTemporal(){
        return codigoTemporal;
    }
    
    public void setCodigoTemporal(int codigoTemporal){
        this.codigoTemporal = codigoTemporal;
    }
       
    // M�todo para saber si hace o no falta pista de precisi�n
    public abstract boolean requierePistaPrecision();
    
}