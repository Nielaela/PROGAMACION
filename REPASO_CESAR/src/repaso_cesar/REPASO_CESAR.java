package repaso_cesar;

import java.util.Scanner;

/*Cifrado César
El cifrado César es una técnica criptográfica que consiste en sustituir un carácter por otro mediante un desplazamiento alfabético. Por ejemplo, si el desplazamiento indicado es 3, la letra a será sustituida por la letra d, la b por la e y así sucesivamente. Si sobrepasamos la letra z, se vuelve a empezar el alfabeto.
Para descifrar un mensaje con esta codificación el desplazamiento a usar será negativo.

El programa solicitado recibirá por teclado un mensaje y solicitará mediante un menú si la tarea a realizar será codificar o decodificar este mensaje.
Ejemplo de menú:
	1.- Codificar
	2.- Decodificar*/
public class REPASO_CESAR {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean menu = true;
        String opciones = "";
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";

        int desplazamiento = 0;
        String mensaje = "";
        String salida = "";
        int posicion1 = 0;
        int posicion2 = 0;
        char letra1;
        char letra2;

        while (menu) {
            System.out.println("CIFRADO CESAR");
            System.out.println("Eliga una opcion");
            System.out.println("1. Codificar");
            System.out.println("2. Decodificar");
            System.out.println("0. Salir");

            opciones = teclado.nextLine();
            switch (opciones) {
                case "1":
                    System.out.println("1. Codificar");
                    System.out.println("Introduce el contenido a codificar");
                    mensaje = teclado.nextLine();

                    System.out.println("Introduce el nº de desplazamientos para la codificación");
                    desplazamiento = teclado.nextInt();

                    mensaje = mensaje.toLowerCase();

                    for (int i = 0; i < mensaje.length(); i++) {
                        if (mensaje.charAt(i) == ' ') {
                            salida = salida + " ";
                            
                        } else if (Character.isDigit(mensaje.charAt(i))) {
                            salida = salida + mensaje.charAt(i);
                            
                        } else {

                            letra1 = mensaje.charAt(i);

                            for (int j = 0; j < abecedario.length(); j++) {
                                if (letra1 == abecedario.charAt(j)) {
                                    posicion1 = j;
                                }
                            }
                            posicion2 = posicion1 + desplazamiento;

                            if (posicion2 > 26) {
                                posicion2 = posicion2 - 27;
                            }

                            letra2 = abecedario.charAt(posicion2);

                            salida = salida + letra2;

                        }
                    }
                    System.out.println("La palabra ingresada es " + mensaje + " y su codificación es " + salida);

                    break;

                case "2":
                    System.out.println("2. Decodificar");
                    System.out.println("Introduce el contenido a decodificar");
                    mensaje = teclado.nextLine();

                    System.out.println("Introduce el nº de desplazamientos para la decodificación");
                    desplazamiento = teclado.nextInt();

                    mensaje = mensaje.toLowerCase();

                    for (int i = 0; i < mensaje.length(); i++) {
                        if (mensaje.charAt(i) == ' ') {
                            salida = salida + " ";
                            
                        } else if (Character.isDigit(mensaje.charAt(i))) {
                            salida = salida + mensaje.charAt(i);
                            
                        } else {
                            letra1 = mensaje.charAt(i);

                            for (int j = 0; j < abecedario.length(); j++) {
                                if (letra1 == abecedario.charAt(j)) {
                                    posicion1 = j;
                                }
                            }
                            posicion2 = posicion1 - desplazamiento;

                            if (posicion2 < 0) {
                                posicion2 = posicion2 + 27;
                            }

                            letra2 = abecedario.charAt(posicion2);
                            salida = salida + letra2;

                        }

                    }
                    System.out.println("La palabra ingresada es " + mensaje + " y su decodificación es " + salida);
                    break;
                case "0":
                    System.out.println("0. Salida");
                    menu = false;

                default:
                    System.out.println("Elige una opción entre 1 y 2");
            }

        }

    }

}
