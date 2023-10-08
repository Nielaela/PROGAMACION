
package calculofecha;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Clase principal que contiene el método main que manejara un menu que llame a cada método para mostrar por pantalla los resulados de los calculos.
 * Se controlará la entrada de datos con varios métodos de validacion
 * @author Daniela Ripoll
 */
public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int dia = 0;
        int mes = 0;
        int anio = 0;

        //variables control menu
        boolean salida = true;
        int menu = -1;

        Utilidades c = new Utilidades();

        while (salida) {
            try {
                System.out.println("CALCULO FECHA HASTA EL 31/12/2023");
                System.out.println("1. Calcular días");
                System.out.println("0. Salir");
                System.out.println("Elige una opción (1 o 0)");

                menu = teclado.nextInt();

                switch (menu) {
                    case 1:
                        System.out.println("Calcular días");
                        try {

                            System.out.println("Introduce la fecha en formato numérico");
                            System.out.println("La fecha que va a introducir tiene que estar comprendida entre el 1/1/1 y el 31/12/2024");
                            System.out.println("Año");
                            anio = teclado.nextInt();
                            if (c.validarAnio(anio)) {
                                throw new Exception("El año tiene que estar comprendido entre 1 y 2023\n");
                            }
                            System.out.println("Mes");
                            mes = teclado.nextInt();
                            if (c.validarMes(mes)) {
                                throw new Exception("El mes tiene que estar comprendido entre 1 y 12\n");
                            }
                            System.out.println("Día");
                            dia = teclado.nextInt();
                            if (c.validarDia(dia, mes, anio)) {
                                throw new Exception("El día introducido no es correcto\n");

                            }

                            System.out.println("Ha introducido la fecha " + dia + "/" + mes + "/" + anio);
                            System.out.println("El número de días de años completos hasta el 31/12/2023 es: " + c.diasAnio(anio));
                            System.out.println("El número de días de meses completos hasta el 31/12/2023 es: " + c.diasMes(mes, anio));
                            System.out.println("El número de días de meses incompletos hasta el 31/12/2023 es: " + c.diasMesIncomp(dia, mes, anio));
                            int diasTotal = 0;
                            diasTotal = c.diasAnio(anio) + c.diasMes(mes, anio) + c.diasMesIncomp(dia, mes, anio);
                            System.out.println("El número de días totales hasta el 31/12/2023 es: " + diasTotal +"\n");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("SALIR");
                        System.out.println("Ha salido de la aplicación");
                        salida = false;
                        break;

                    default:
                        System.out.println("Elige entre una opciónes indicadas.");
                        System.out.println();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Pon un numero, no una letra\n");
                teclado.next();

            }

        }

    }
}
