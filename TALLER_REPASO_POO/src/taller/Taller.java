package taller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author niela
 */
public class Taller {

    private ArrayList<Vehiculo> parking = new ArrayList();

    public void anadirVehiculo() {
        Scanner teclado = new Scanner(System.in);

        //DEC VARIABLES 
        String nombre, dni, matricula = "";
        int numPuertas = 0;
        int numPlazas = 0;
        int potencia = 0;
        int factorPot = 0;

        boolean esElectrica = false;

        String tipoMoto = "";
        String tipoVehiculo = "";

        System.out.println("AGREGAR VEHICULO PARKING");
        System.out.println("Indique datos del conductor");
        do {
            System.out.println("Nombre (entre 5 y 15 letras máximo)");
            nombre = teclado.nextLine();
        } while (!Conductor.comprNombre(nombre));
        do {
            System.out.println("DNI");
            dni = teclado.nextLine().toUpperCase();
        } while (Conductor.validarDNI(dni));

        System.out.println("Conductor registrado");
        Conductor conductor = new Conductor(nombre, dni);
        do {
            System.out.println("Matricula del vehiculo");
            matricula = teclado.nextLine().toUpperCase();

        } while (!Vehiculo.comprMatricula(matricula));
        if (comprobarVehiculoExistente(matricula)) {
            System.out.println("El vehículo con matrícula " + matricula + " ya existe en el parking");

        } else {

            do {
                System.out.println("Indique tipo de vehiculo a registrar: ");
                System.out.println("1 - COCHE");
                System.out.println("2 - MOTO");
                tipoVehiculo = teclado.nextLine();
            } while (!tipoVehiculo.equals("1") && !tipoVehiculo.equals("2"));
            if (tipoVehiculo.equals("1")) {
                System.out.println("Ha seleccionado vehiculo tipo COCHE");
                do {
                    try {
                        System.out.println("Indique número de puertas (entre 2 y 5)");
                        numPuertas = teclado.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\nDDebe introducirlo en formato numerico");
                        teclado.nextLine();
                    }
                } while (numPuertas > 5 || numPuertas < 2);

                do {
                    try {
                        System.out.println("Indique número de plazas (entre 1 y 9)");
                        numPlazas = teclado.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\nDebe introducirlo en formato numerico");
                        teclado.nextLine();
                    }
                } while (numPlazas > 9 || numPlazas < 1);
                do {
                    try {
                        System.out.println("Indique factor de potencia (entre 1 y 5)");
                        factorPot = teclado.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\nDebe introducirlo en formato numerico");
                        teclado.nextLine();
                    }
                } while (factorPot > 5 || factorPot < 1);

                //constructor
                Coche coche = new Coche(numPuertas, numPlazas, factorPot, conductor, matricula);
                parking.add(coche);
                System.out.println("COCHE REGISTRADO");

            } else if (tipoVehiculo.equals("2")) {
                System.out.println("Ha seleccionado vehiculo tipo MOTO");
                System.out.println("Indique la potencia: ");
                potencia = teclado.nextInt();
                teclado.nextLine();
                do {
                    System.out.println("¿Es electrica la moto? Eliga una opción: ");
                    System.out.println("1 - SI");
                    System.out.println("2 - NO");
                    tipoMoto = teclado.nextLine();

                } while (!tipoMoto.equals("1") && !tipoMoto.equals("2"));
                if (tipoMoto.equals("1")) {
                    esElectrica = true;
                    System.out.println("Ha seleccionado : moto electrica.");
                } else if (tipoMoto.equals("2")) {
                    esElectrica = false;
                    System.out.println("Ha seleccionado : moto no electrica.");
                }

                //constructor
                Moto moto = new Moto(potencia, esElectrica, factorPot, conductor, matricula);
                parking.add(moto);
                System.out.println("MOTO REGISTRADA");

            }
        }
    }

    public boolean comprobarVehiculoExistente(String matricula) {
        for (Vehiculo i : parking) {
            if (matricula.equals(i.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    public void visualizarParking() {
        for (Vehiculo i : parking) {
            i.verFicha();
        }

    }

    public void eliminarVehiculo() {
        String matricula = "";
        boolean encontrado = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la matricula del vehiculo a eliminar");
        matricula = teclado.nextLine().toUpperCase();

        for (int i = 0; i < parking.size(); i++) {
            if (matricula.equals(parking.get(i).getMatricula())) {
                parking.remove(i);
                System.out.println("Vehiculo eliminado del parking");
                encontrado = true;
            }

        }
        if (encontrado = false) {
            System.out.println("No existe ningun vehiculo con la matrícula indicada");
        }
    }
    /*      for(Vehiculo i : parking){
            if(matricula.equals(i.getMatricula())){
                parking.remove(i);
                System.out.println("Vehiculo eliminado del parking");
                encontrado = true;
            }
        }
        if(encontrado = false){
            System.out.println("No existe ningun vehiculo con la matrícula indicada");
        }
    }*/
}
