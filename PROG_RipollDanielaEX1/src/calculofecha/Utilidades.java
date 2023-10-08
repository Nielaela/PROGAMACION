
package calculofecha;



/**
 * Clase Utilidades, se definirán todos los métodos que se utilizarán en el calculo de la fecha, también las validaciones para la correcta entrada de datos.
 * @author Daniela Ripoll
 */
public class Utilidades {

    //METODOS DE CALCULO   
    /**
     * Hará una resta para saber los años completos que transcurren y luego se multiplica por el total de dias de un año.
     * Comprobará con un bucle for cada año en el rango si es bisiesto, IMPORTANTE, empieza por el año+1 porque el for incluye el año inicial que no estará completo.
     * @param anio
     * @return 
     */
    public static int diasAnio(int anio) {
        int diasAnio = 0;
        int anioBis = 0;
        diasAnio = (2023 - anio) * 365;

        //bucle for para recorrer todos los años y comprobar si es bisiesto o no (hay +1 porque el primer año que recorre no es completo y puede coincidir que sea bisiesto y contaria un día de mas)
        for (int i = anio + 1; i <= 2023; i++) {
            //llamo al metodo de comprobar si es bisiesto o no
            if (bisiesto(anio)) {
                anioBis++;
                diasAnio = diasAnio + anioBis;
            }

        }
        return diasAnio;
    }
/**
 * Switch que valorará los dias de meses completos en cada mes, resta del total de días del año los dias de meses anteriores al mes indicado.
 * Comprobará si el año indicado es bisiesto para sumar un dia adicional al calculo
 * @param mes
 * @param anio
 * @return 
 */
    public static int diasMes(int mes, int anio) {
        int diasMes = 0;

        switch (mes) {
            case 1:
                diasMes = 365 - 31;
                break;
            case 2:
                diasMes = 365 - 31 - 28;
                break;
            case 3:
                diasMes = 365 - 31 - 28 - 31;
                break;
            case 4:
                diasMes = 365 - 31 - 28 - 31 - 30;
                break;
            case 5:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31;
                break;
            case 6:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30;
                break;
            case 7:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30 - 31;
                break;
            case 8:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31;
                break;
            case 9:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30;
                break;
            case 10:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30 - 31;
                break;
            case 11:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30 - 31 - 30;
                break;
            case 12:
                diasMes = 365 - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30 - 31 - 30 - 31;
                break;

            default:
                throw new AssertionError();
        }

        //COMPROBACIÓN SI ES BISIESTO (solo podria sumar en la situación de empezar en enero (con meses completos)
        if ((bisiesto(anio)) && (mes == 1)) {
            diasMes = diasMes + 1;
            return diasMes;
        }

        return diasMes;
    }
/**
 * Restará del total del dias del mes indicado, el dia por el que compienza +1 (+1 porque restaria el dia en el que comienza el calculo...)
 * ----Pdría resolverse tambien con un control con IF/ELSEIF, indicando los meses que tengan 30 días, los de 31 y el caso de febrero.
 * @param dia
 * @param mes
 * @param anio
 * @return 
 */
    public static int diasMesIncomp(int dia, int mes, int anio) {
        int diasMesIncomp = 0;
        switch (mes) {
            case 1:
                diasMesIncomp = 31 - dia + 1;
                break;
            case 2:
                diasMesIncomp = 28 - dia + 1;
                break;
            case 3:
                diasMesIncomp = 31 - dia + 1;
                break;
            case 4:
                diasMesIncomp = 30 - dia + 1;
                break;
            case 5:
                diasMesIncomp = 31 - dia + 1;
                break;
            case 6:
                diasMesIncomp = 30 - dia + 1;
                break;
            case 7:
                diasMesIncomp = 31 - dia + 1;
                break;
            case 8:
                diasMesIncomp = 31 - dia + 1;
                break;
            case 9:
                diasMesIncomp = 30 - dia + 1;
                break;
            case 10:
                diasMesIncomp = 31 - dia + 1;
                break;
            case 11:
                diasMesIncomp = 30 - dia + 1;
                break;
            case 12:
                diasMesIncomp = 31 - dia + 1;
                break;

            default:
                throw new AssertionError();
        }

        //COMPROBACIÓN SI ES BISIESTO (solo podria sumar en la situación de empezar en enero (con meses completos)
        if ((bisiesto(anio)) && (mes == 2)) {
            diasMesIncomp = diasMesIncomp + 1;
            return diasMesIncomp;
        }

        return diasMesIncomp;
    }
/**
 * Comprobación de año bisiesto
 * @param anio
 * @return 
 */
    private static boolean bisiesto(int anio) {
        if (((anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0))) {
            //   System.out.println("Es bisiesto");
            return true;
        } else {
            //   System.out.println("No es bisiesto");
            return false;
        }
    }

    //VALIDACIONES
    /**
     * Se tendrá en cuenta cuando los días no esten comprendidos en dias de mes reales.
     * Tambien para los meses que tienen 30 días y se les indique 31.
     * Y en caso de elegir el mes de febrero, controlar cuando no sea bisiesto si se le indica dia 29.
     * @param dia
     * @param mes
     * @param anio
     * @return 
     */
    public static boolean validarDia(int dia, int mes, int anio) {
        if (dia < 1 || dia > 31) {
            return true;
        } else if ((dia == 31) && (mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11)) {
            return true;
        } else if (mes == 2) {
            if(dia > 29){
                return true;
            }else if ((!bisiesto(anio)) && (dia >28)){
                return true;
            }
        }
        return false;
    }
/**
 * Comprobación del rango de meses
 * @param mes
 * @return 
 */
    public static boolean validarMes(int mes) {
        if (mes < 1 || mes > 12) {
            return true;
        }
        return false;
    }
/**
 * Comprobación del rango de años
 * @param anio
 * @return 
 */
    public static boolean validarAnio(int anio) {
        if ((anio < 1 ) || (anio > 2023)) {
            return true;
        }
        return false;
    }
}
