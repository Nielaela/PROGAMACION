package banco;

import java.io.Serializable;

/**
 *
 * @author daniela ripoll
 */
public class Empresas extends Clientes implements Serializable{

    //METODOS
    private double getCuota(double saldo) {
        double cuota = 0;
        if (saldo < 0) {
            cuota = saldo * 0.10 * (-1);
        } else if (saldo >= 0 && saldo <= 10000) {
            cuota = saldo * 0.05;
        } else {
            cuota = saldo * 0.02;
        }
        return cuota;
    }

    
    //CONSTRUCTOR
    
    public Empresas(String nombre, String ID, String PIN, double saldo) {
        super(nombre, ID, PIN, saldo);
    }

    @Override
    public String toString() {
        return "Cliente:\n" + "nombre=" + getNombre() + ", saldo=" + getSaldo() + ", cuota=" + getCuota(getSaldo());
    }
}
