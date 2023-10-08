/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author niela
 */
public class Conductor {
    //DEC ATRIBUTOS
    private String nombre;
    private String dni;
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    //CONSTRUCTOR
    public Conductor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    

    //VALIDACIONES
    public static boolean comprNombre(String nombre){
        return nombre.matches("^[A-Z][a-zA-Z ]{4,14}$");
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

    
}
