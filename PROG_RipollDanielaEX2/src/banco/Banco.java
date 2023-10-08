package banco;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Banco, aqui se definen todos los métodos que manejara la clase
 * Principal. Define la colleccion que guardará los datos de los clientes.
 * También tendrá los métodos de guardado y recuperación de datos.
 *
 * @author daniela ripoll
 */
public class Banco implements Serializable {

    private ArrayList<Clientes> listaClientesBanco = new ArrayList();

    public void agregarCliente() {
        Scanner teclado = new Scanner(System.in);
        boolean esParticular = false;
        boolean esEmpresa = false;
        int tipoCliente = 0;

        String ID;
        String nombre;
        String PIN;
        double saldo = 0;
        boolean saldoCompr = false;

        do {
            try {
                System.out.println("NUEVO CLIENTE.");
                System.out.println("Indique tipo de cliente:");
                System.out.println("1 - Particular");
                System.out.println("2 - Empresa");
                System.out.println("Eliga una opción: 1 o 2");

                tipoCliente = teclado.nextInt();
                teclado.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Debe introducir una opción válida. (1) Particular, (2) Empresa");
                teclado.next();
            }

        } while ((tipoCliente != 1) && (tipoCliente != 2));

        if (tipoCliente == 1) {
            esParticular = true;
            System.out.println("Ha seleccionado tipo cliente: PARTICULAR");
            System.out.println("Introduzca los siguientes datos:");
            //Validacion del ID
            do {
                System.out.println("ID");
                System.out.println("(DNI del cliente)");
                ID = teclado.nextLine().toUpperCase();
            } while (Clientes.validarDNI(ID));

            //COMPROBACIÓN PARA EVITAR CREAR CLIENTES CON MISMO ID
            if (comprobarClienteExistente(ID)) {
                System.out.println("El DNI introducido ya existe para otro cliente.");
            } else {
                //Validacion nombre
                do {
                    System.out.println("NOMBRE");
                    System.out.println("(Formato entre 5 y 25 caracteres)");
                    nombre = teclado.nextLine();
                } while (Clientes.validarNombre(nombre));
                //Validación PIN
                do {
                    System.out.println("PIN");
                    System.out.println("(Formato entre 0000 y 9999)");
                    PIN = teclado.nextLine();
                } while (!Clientes.validarPin(PIN));

                do {
                    try {
                        System.out.println("SALDO");
                        saldo = teclado.nextDouble();
                        teclado.nextLine();
                        saldoCompr = true;
                    } catch (InputMismatchException e) {
                        System.out.println("\nDebe introducir un saldo en formato numerico");
                        teclado.nextLine();
                    }
                } while (!saldoCompr);

                Particulares particular = new Particulares(nombre, ID, PIN, saldo);
                listaClientesBanco.add(particular);
                System.out.println("Cliente con ID " + ID + " registrado.");
            }

        } else {
            esEmpresa = true;
            System.out.println("Ha seleccionado tipo cliente: EMPRESA");
            System.out.println("Introduzca los siguientes datos:");
            //Validacion del ID
            do {
                System.out.println("ID");
                System.out.println("(CID del cliente)");
                ID = teclado.nextLine().toUpperCase();
            } while (Clientes.validarCIF(ID));

            //COMPROBACIÓN PARA EVITAR CREAR CLIENTES CON MISMO ID
            if (comprobarClienteExistente(ID)) {
                System.out.println("El CIF introducido ya existe para otro cliente.");
            } else {
                //Validacion nombre
                do {
                    System.out.println("NOMBRE");
                    System.out.println("(Formato entre 5 y 25 caracteres)");
                    nombre = teclado.nextLine();
                } while (Clientes.validarNombre(nombre));
                //Valicacion PIN
                do {
                    System.out.println("PIN");
                    System.out.println("(Formato entre 0000 y 9999)");
                    PIN = teclado.nextLine();
                } while (!Clientes.validarPin(PIN));

                do {
                    try {
                        System.out.println("SALDO");
                        saldo = teclado.nextDouble();
                        teclado.nextLine();
                        saldoCompr = true;
                    } catch (InputMismatchException e) {
                        System.out.println("\nDebe introducir un saldo en formato numerico");
                        teclado.nextLine();
                    }
                } while (!saldoCompr);

                Empresas empresa = new Empresas(nombre, ID, PIN, saldo);
                listaClientesBanco.add(empresa);
                System.out.println("Cliente con ID " + ID + " registrado.");
            }

        }
    }

    public boolean comprobarClienteExistente(String ID) {
        for (int i = 0; i < listaClientesBanco.size(); i++) {
            if (ID.equals(listaClientesBanco.get(i).getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Bucle que recorre todo el arraylist, primero controlará si existe el dni
     * y el pin (para evitar sacar clientes con el mismo pin)
     *
     * @param ID
     */
    public void mostrarDatosCliente(String ID) {
        Scanner teclado = new Scanner(System.in);

        boolean comprPin = false;
        String PIN;
        System.out.println("Introduzca el PIN");
        PIN = teclado.nextLine();

        for (Clientes i : listaClientesBanco) {
            if ((ID.equals(i.getID())) && (PIN.equals(i.getPIN()))) {
                System.out.println(i.toString());
                comprPin = true;

            }
        }
        if (comprPin == false) {
            System.out.println("PIN erroneo ");
        }
    }

    public void guardarDatos() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fichSalida = new FileOutputStream("clientes.dat");
            oos = new ObjectOutputStream(fichSalida);

            for (Clientes x : listaClientesBanco) {
                oos.writeObject(x);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void recuperarDatos() {
        ObjectInputStream ois = null;
        try {
            FileInputStream fichEntrada = new FileInputStream("clientes.dat");
            ois = new ObjectInputStream(fichEntrada);
            //while que traerá todos los objetos que esta leyendo el flujo de datos del fichero agenda.dat
            //añadirá de nuevo al arraylist esos objetos.
            while (true) {
                Clientes x = (Clientes) ois.readObject();
                listaClientesBanco.add(x);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe fichero con datos");
        } catch (EOFException ex) {
            System.out.println("Fichero con datos de clientes existente");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
