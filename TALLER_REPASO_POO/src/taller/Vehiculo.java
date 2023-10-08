/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author niela
 */
public abstract class Vehiculo {

    //DEC ATRIBUTOS
    private Conductor conductor;
    private String matricula;

    //GETTERS Y SETTERS
    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    //CONSTRUCTOR
    public Vehiculo(Conductor conductor, String matricula) {
        this.conductor = conductor;
        this.matricula = matricula;
    }

    //MÉTODOS
    public double calcularCuota(){
        double cuota = 275;
        return cuota;
    }
    
   
    public void verFicha() {
        System.out.println(" VEHICULO "
                + "\nConductor=" + conductor.getNombre() 
                + "\nDNI " + conductor.getDni() 
                + "\nMatricula = " + matricula 
                + "\n Cuota = " + calcularCuota());
    }

    //VALIDACIONES
    public static boolean comprMatricula (String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
       //return matricula.matches("^[0-9]{4}[B|C|D|F|G|H|J|K|L|M|N|P|Q|R|S|T|V|W|X|Y|Z]{3}$"); seria la opción válida porque solo lleva consonantes.
    }
    
}
