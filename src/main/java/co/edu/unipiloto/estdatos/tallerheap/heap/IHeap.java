/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.tallerheap.heap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 * @param <T>
 */
public class IHeap<T extends Comparable<T>> {

    private List<T> heap;

    public IHeap() {
        heap = new ArrayList<>();
    }

    public void add(T elemento) {
        heap.add(elemento);
        siftUp();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("El montículo está vacío");
        }
        return heap.get(0);
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("El montículo está vacío");
        }
        T elemento = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        siftDown();
        return elemento;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
            if (current.compareTo(parent) > 0) {
                // Swap current and parent
                heap.set(index, parent);
                heap.set(parentIndex, current);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown() {
        int index = 0;
        int lastIndex = heap.size() - 1;
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largestIndex = index;

            if (leftChildIndex <= lastIndex && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex <= lastIndex && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != index) {
                // Swap index and largestIndex
                T temp = heap.get(index);
                heap.set(index, heap.get(largestIndex));
                heap.set(largestIndex, temp);
                index = largestIndex;
            } else {
                break;
            }
        }
    }
}
