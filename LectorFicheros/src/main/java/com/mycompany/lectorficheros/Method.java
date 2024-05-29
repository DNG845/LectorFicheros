/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lectorficheros;

/**
 *
 * @author danny
 */
public class Method {
    private final String Nombre;
    private final String Cuerpo;
    private final String complexity;

    public Method(String nombre, String cuerpo) {
        this.Nombre = nombre;
        this.Cuerpo = cuerpo;
        this.complexity = calculoComplexity();
    }
    //Optiene el nombre del metodo
    public String getNombre() {
        return Nombre;
    }
    //Optiene el cuerpo del metodo
    public String getCuerpo() {
        return Cuerpo;
    }
    //Optiene la complejidad del metodo
    public String getComplexity() {
        return complexity;
    }
    //Hace los calculos de la complejidad
    private String calculoComplexity() {
        int loops = 0;
        int recursions = 0;

        //Detecta loops en el metodo
        String[] lines = Cuerpo.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("for") || line.startsWith("while")) {
                loops++;
            } else if (line.contains(Nombre + "(")) {
                recursions++;
            }
        }
        //Detecta la recursividad del metodo
        if (recursions > 0) {
            return "O(n^" + (recursions + 1) + ")";
        } else if (loops > 0) {
            return "O(n)";
        } else {
            return "O(1)";
        }
    }
}
