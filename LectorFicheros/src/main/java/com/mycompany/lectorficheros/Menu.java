/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lectorficheros;

/**
 *
 * @author danny
 */
import java.util.Scanner;

public class Menu {
    //Muestra la lista y la lista de metodos
    public static void display(CircularLinkedList methodsList) {
        Scanner scanner = new Scanner(System.in);
        //Menu de opciones
        while (true) {
            System.out.println("1. Mostrar todos los metodos");
            System.out.println("2. Mostrar complejidad de los metodos");
            System.out.println("3. Mostrar metodos uno por uno");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                //Muestra todos los metodos
                case 1 -> methodsList.display();
                //Muestra la complejidad
                case 2 -> displayComplexiti(methodsList);
                //Muestra los metodos y su complejidad haciendo el recorrido 1 por 1
                case 3 -> displayMethod(methodsList, scanner);
                case 4 -> System.exit(0);
                default -> System.out.println("Eror Fatal utilice otra opcion");
            }
                    }
    }
    
    private static void displayComplexiti(CircularLinkedList methodsList) {
        CircularLinkedList.Node current = methodsList.head;
        if (current != null) {
            do {
                Method method = current.method;
                System.out.println("Metodo: " + method.getNombre() + ", "
                        + "Complejidad: " + method.getComplexity());
                current = current.next;
            } while (current != methodsList.head);
        }
    }

    private static void displayMethod(CircularLinkedList methodsList, 
            Scanner scanner) {
        CircularLinkedList.Node current = methodsList.head;
        if (current == null) {
            System.out.println("No hay metodos en la lista.");
            return;
        }
        //Segunda lista de opciones para mostrar el avance 1 por 1
        while (true) {
            Method method = current.method;
            System.out.println("Metodo: " + method.getNombre());
            System.out.println("Cuerpo: " + method.getCuerpo());
            System.out.println("Complejidad: " + method.getComplexity());
            System.out.println("1. Siguiente metodo");
            System.out.println("2. Metodo anterior");
            System.out.println("3. Volver al menu");
            System.out.print("Seleccione una opcion: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1 -> current = current.next;
                case 2 -> current = getNodoAnterior(methodsList, current);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }
    //Volver al nodo anterior
    private static CircularLinkedList.Node getNodoAnterior(
            CircularLinkedList methodsList, CircularLinkedList.Node current) {
        CircularLinkedList.Node node = methodsList.head;
        if (node != null) {
            do {
                if (node.next == current) {
                    return node;
                }
                node = node.next;
            } while (node != methodsList.head);
        }
        return current;
    }
}
