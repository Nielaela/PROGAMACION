
package banco;

import java.io.Serializable;


/**
 *
 * @author daniela ripoll
 */
public abstract class Clientes implements Serializable{
    
    //DECLARACION ATRIBUTOS
    private String nombre;
    private String ID;
    private String PIN;
    private double saldo;
    
    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //CONSTRUCTOR
    public Clientes(String nombre, String ID, String PIN, double saldo) {
        this.nombre = nombre;
        this.ID = ID;
        this.PIN = PIN;
        this.saldo = saldo;
    }
    
    
    //MÉTODOS
    private double getCuota(double saldo){
        double cuota = 0;
        return cuota;
    }
    
    @Override
    public String toString(){
        return "Cliente:\n" + "nombre=" + nombre + ", saldo=" +  (saldo) + ", cuota=" + getCuota(saldo);
    }
    
    //VALIDACIONES
    public static boolean validarNombre(String nombre){
        if(nombre.length() < 5 || nombre.length() > 25){
            return true;
        }
        return false;
    }
    
    public static boolean validarDNI(String ID){
        String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (ID.length() != 9) {
            return true;
        }
        //Obtención del número del DNI
        String NumeroDNI = ID.substring(0, (ID.length() - 1));
        //Obtención de la letra del DNI
        char letraDNI = ID.charAt(ID.length() - 1);

        //COMPROBACIÓN DEL NÚMERO DEL DNI
        int numDNI;
        try {
            numDNI = Integer.parseInt(NumeroDNI);   //conversión del dni string a numero integer
        } catch (NumberFormatException e) {
            return true;
        }
        //COMPROBACIÓN DE LA LETRA DEL DNI
        //La excepción saltará cuando la letra no sea alfabetica.
        if (!Character.isAlphabetic(letraDNI)) {
            return true;
        }
        //Calculamos la letra, segun el algoritmo del modulo 23

        char nuevaLetra = LETRAS_DNI.charAt(numDNI % 23);
        // Si la letra inicial, y la obtenida no son iguales, saltará la excepción.
        if (letraDNI != nuevaLetra) {
            return true;
        }

        return false;
       
    }
    //IGUAL QUE LA VALIDACION DEL DNI PERO TENIENDO EN CUENTA QUE ES UN %17 Y EL TAMAÑO Y POSICION DE LA LETRA DEL ID.
    public static boolean validarCIF(String ID){
        String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (ID.length() != 10) {
            return true;
        }
        //Obtención del número del DNI
        String NumeroDNI = ID.substring(1, (ID.length()));
        //Obtención de la letra del CIF
        char letraDNI = ID.charAt(0);

        //COMPROBACIÓN DEL NÚMERO DEL DNI
        int numDNI;
        try {
            numDNI = Integer.parseInt(NumeroDNI);   //conversión del dni string a numero integer
        } catch (NumberFormatException e) {
            return true;
        }
        //COMPROBACIÓN DE LA LETRA DEL DNI
        //La excepción saltará cuando la letra no sea alfabetica.
        if (!Character.isAlphabetic(letraDNI)) {
            return true;
        }
        //Calculamos la letra, segun el algoritmo del modulo 17

        char nuevaLetra = LETRAS_DNI.charAt(numDNI % 17);
        // Si la letra inicial, y la obtenida no son iguales, saltará la excepción.
        if (letraDNI != nuevaLetra) {
            return true;
        }
        return false;
       
    }
    public static boolean validarPin(String PIN){
        return PIN.matches("[0-9]{4}");
    }
    
}
