/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lectorficheros;

/**
 *
 * @author danny
 */
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Leer el archivo y obtener los metodos
            CircularLinkedList methodsList = FileReader.readJavaFile(""
                    + "src/Ficheros/Fichero.java");
            
            // Muestra el menu de opcioes
            Menu.display(methodsList);
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
