/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author niela
 */
public class Moto extends Vehiculo {
    //DEC ATRIBUTOS
    private int potencia;
    private boolean electrica;
    private int factorPot;
    
    //GETTERS Y SETTERS

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean isElectrica() {
        return electrica;
    }

    public void setElectrica(boolean electrica) {
        this.electrica = electrica;
    }

    public int calculoFactorPot(){
        if(potencia < 25){
            factorPot = 1;
        }else if (potencia >= 50 && potencia <= 25){
            factorPot = 2;
        }else{
            factorPot = 3;
        }
        return factorPot;
    }
    //CONSTRUCTOR
    public Moto(int potencia, boolean electrica, int factorPot, Conductor conductor, String matricula) {
        super(conductor, matricula);
        this.potencia = potencia;
        this.electrica = electrica;
        this.factorPot = calculoFactorPot();
    }
    //MÉTODOS
     @Override
    public void verFicha() {
        super.verFicha();
        System.out.println("DATOS MOTO"
                + "\n Potencia = " + potencia       
                + "\n Factor de potencia = " + calculoFactorPot());
        if(electrica){
            System.out.println("Moto electrica");
        }else{
            System.out.println("Moto no electrica");
        }
    }
    
    @Override
    public double calcularCuota(){
        double cuota = super.calcularCuota();
        double cuotaFinal = cuota + (cuota*0.04*factorPot);
        if(electrica){
            cuotaFinal = cuotaFinal + 25;
        }
        return cuotaFinal;
        
    }
}
