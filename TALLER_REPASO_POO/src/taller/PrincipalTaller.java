/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

import java.util.Scanner;

/**
 *
 * @author niela
 */
public class PrincipalTaller {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean menuSalida = true;
        String menu = "";

        Taller gestionMenu = new Taller();
        
        while (menuSalida) {
            
            System.out.println("MENU");
            System.out.println("1. AÑADIR VEHICULO .");
            System.out.println("2. VISUALIZAR PARKING. ");
            System.out.println("3. ELIMINAR VEHICULO");
            System.out.println("0. SALIR");
            System.out.println("Elige una.");
            menu = teclado.nextLine();

            switch (menu) {
                case "1":
                    //DEC VARIABLES SUBMENU
                    boolean submenu1 = true;
                    String menu1 = "";
                    while (submenu1) {

                        System.out.println("Elige una de las siguientes opciones");
                        System.out.println("1. AÑADIR VEHICULO");
                        System.out.println("0. VOLVER AL MENÚ ANTERIOR\n");

                        menu1 = teclado.nextLine();
                        switch (menu1) {
                            case "1":
                                gestionMenu.anadirVehiculo();
                                break;
                            case "0":
                                System.out.println("Volvió al menú anterior");
                                submenu1 = false;
                                break;

                            default:
                                System.out.println("Tiene que elegir una de las opciones válidas. 1 o 0");
                        }
                    }

                    break;

                case "2":
                    System.out.println("2. VISUALIZAR PARKING. ");
                    gestionMenu.visualizarParking();
                    break;
                    
                case "3":
                    System.out.println("3. ELIMINAR VEHICULO. ");
                    gestionMenu.eliminarVehiculo();
                    break;
                case "0":
                    System.out.println("0. SALIR");
                    System.out.println("Ha salido de la aplicación.");
                    menuSalida = false;
                    break;

                default:
                    System.out.println("Tiene que elegir una de las opciones válidas. 0 para salir de la aplicacion");
            }

        }

    }

}
