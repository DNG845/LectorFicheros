/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lectorficheros;

/**
 *
 * @author danny
 */
public class CircularLinkedList {
    Node head;
    private Node tail;
    //Inserta un nodo
    public void insert(Method method) {
        Node newNode = new Node(method);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }
    //Muestra el nodo
    public void display() {
        Node current = head;
        if (head != null) {
            do {
                System.out.println(current.method.getNombre());
                current = current.next;
            } while (current != head);
        }
    }
    //Representa un nodo en la lista
    public class Node {
        Method method;
        Node next;

        public Node(Method method) {
            this.method = method;
        }
    }
}
