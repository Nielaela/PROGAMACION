/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author niela
 */
public class Coche extends Vehiculo {

    //DEC ATRIBUTO
    private int numPuertas;
    private int numPlazas;
    private int FactorPot;

    //GETTERS Y SETTERS
    //CONSTRUCTOR
    public Coche(int numPuertas, int numPlazas, int FactorPot, Conductor conductor, String matricula) {
        super(conductor, matricula);
        this.numPuertas = numPuertas;
        this.numPlazas = numPlazas;
        this.FactorPot = FactorPot;
    }

    //MÉTODOS
    @Override
    public void verFicha() {
        super.verFicha();
        System.out.println("DATOS COCHE"
                + "\n Numero de puertas = " + numPuertas
                + "\n Numero de plazas = " + numPlazas
                + "\n Factor de potencia = " + FactorPot);
    }
    
    @Override
    public double calcularCuota(){
        double cuota = super.calcularCuota();
        double cuotaFinal = (cuota + (cuota*0.05*FactorPot) + (5.25*numPlazas));
        return cuotaFinal;
        
    }

}
