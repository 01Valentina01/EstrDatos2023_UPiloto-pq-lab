/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.tallerheap.pq;

import java.util.NoSuchElementException;

/**
 *
 * @author User
 * @param <T>
 */
public class MaxPQ<T extends Comparable<T>>{
    private T[] pq;// Arreglo para almacenar los elementos de la cola de prioridad.
    private int n; // Tamaño actual de la cola de prioridad.

    // Constructor sin argumentos para crear una cola de prioridad vacía.
    public MaxPQ() {
        this(1);// Llama al constructor con un tamaño inicial de 1.
    }

    // Constructor para crear una cola de prioridad con un tamaño máximo inicial.
    public MaxPQ(int max) {
        pq = (T[]) new Comparable[max + 1];
        n = 0;
    }

    // Constructor para crear una cola de prioridad a partir de un arreglo de elementos.
    public MaxPQ(T[] a) {
        n = a.length;
        pq = (T[]) new Comparable[n + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = a[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
    }

    // Agrega un elemento a la cola de prioridad.
    public void insert(T v) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);// Duplica el tamaño del arreglo si es necesario.
        }
        pq[++n] = v;
        swim(n);
    }

    // Devuelve el elemento máximo de la cola de prioridad.
    public T max() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola de prioridad está vacía");
        }
        return pq[1];
    }

    // Elimina y devuelve el elemento máximo de la cola de prioridad.
    public T delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola de prioridad está vacía");
        }
        T max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if (n > 0 && n == (pq.length - 1) / 4) {
            resize(pq.length / 2);// Reduce el tamaño del arreglo a la mitad si es necesario.
        }
        return max;
    }

    // Verifica si la cola de prioridad está vacía.
    public boolean isEmpty() {
        return n == 0;
    }

    // Devuelve el número de elementos en la cola de prioridad.
    public int size() {
        return n;
    }

    // Métodos auxiliares para mantener la propiedad de la cola de prioridad.
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // Método para redimensionar el arreglo.
    private void resize(int capacity) {
        T[] temp = (T[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
}
