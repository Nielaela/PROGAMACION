package banco;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Para cada submenú se ha inicializado una variable dentro del comienzo de este para evitar problemas.
 * @author daniela ripoll
 */
public class PrincipalBanco {


    public static void main(String[] args) {
       //DECLARACIÓN DE VARIABLES, PARA EL MENU
        Scanner teclado = new Scanner(System.in);
        boolean salida = true;
        
        Banco gestionBanco = new Banco();
        
        gestionBanco.recuperarDatos();

        while (salida) {
            int menu = -1;
            try {
                System.out.println("BANCO");
                System.out.println("1. Introducir datos de clientes");
                System.out.println("2. Seleccionar cliente");
                System.out.println("0. SALIR");
                System.out.println("---------------\n");

                menu = teclado.nextInt();
                teclado.nextLine();
                switch (menu) {
                    case 1:
                        //dec variables menu
                        boolean submenu1 = true;
                        int menu1 = -1;
                        
                        while (submenu1) {
                            System.out.println("Eliga una opción:");
                            System.out.println("1.AGREGAR NUEVO CLIENTE");
                            System.out.println("0.MENÚ ANTERIOR");
                            System.out.println("---------------\n");

                            menu1 = teclado.nextInt();
                            teclado.nextLine();
                            switch (menu1) {
                                case 1:
                                    gestionBanco.agregarCliente();
                                    break;

                                case 0:
                                    System.out.println("Ha vuelto al menú anterior");
                                    submenu1 = false;
                                    break;
                                default:
                                    System.out.println("Elige entre una opciónes indicadas.");
                                    System.out.println();
                                    break;
                            }
                        }

                        break;
                    case 2:
                        //dec variables menu
                        boolean submenu2 = true;
                        int menu2 = -1;
                        
                        while (submenu2) {
                            String ID;
                            System.out.println("Eliga una opción:");
                            System.out.println("1. Mostrar datos del cliente (Privado)");
                            System.out.println("0. MENÚ ANTERIOR");
                            System.out.println("---------------\n");

                            menu2 = teclado.nextInt();
                            teclado.nextLine();
                            switch (menu2) {
                                case 1:
                                    System.out.println("Introduce el ID del cliente que quiere consultar");
                                    ID = teclado.next().toUpperCase();
                                    if (gestionBanco.comprobarClienteExistente(ID)) {
                                        System.out.println("Cliente con ID " + ID + " existente.");
                                        gestionBanco.mostrarDatosCliente(ID);
                                    } else {
                                        System.out.println("El ID del cliente indicado no está en el sistema.");
                                    }

                                    break;

                                case 0:
                                    System.out.println("Ha vuelto al menú anterior");
                                    submenu2 = false;
                                    break;
                                default:
                                    System.out.println("Elige entre una opciónes indicadas.");
                                    System.out.println();
                                    break;
                            }

                        }

                        break;

                    case 0:
                        System.out.println("0. SALIR");
                        gestionBanco.guardarDatos();
                        System.out.println("Ha salido de la aplicación");
                        salida = false;
                        break;

                    default:
                        System.out.println("Elige entre una opciónes indicadas.");
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Pon un numero, no una letra");
                teclado.next();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }

        }

    }
}
