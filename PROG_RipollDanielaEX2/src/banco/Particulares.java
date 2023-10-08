
package banco;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author daniela ripoll
 */
public class Particulares extends Clientes implements Serializable {
    //METODOS
    private double getCuota(double saldo){
        double cuota = 0;
        if(saldo < 0){
            cuota = saldo * 0.15 *(-1);
        }else if(saldo >= 0 && saldo <= 1000){
            cuota = 5;
        }else{
            cuota = 0;
        }
        return cuota;
    }
    
    //CONSTRUCTOR
    
        public Particulares(String nombre, String ID, String PIN, double saldo){
        super(nombre, ID, PIN, saldo);
    }

    @Override
    public String toString() {
        
        return "Cliente:\n" + "nombre=" + getNombre() + ", saldo=" + (getSaldo()) + ", cuota=" + getCuota(getSaldo());
    }
}
