package datastructures;

import datastructures.Heap.Heap;

public class MinHeap extends Heap {
    public MinHeap(int maxSize) {
        this.heap = new int[maxSize + 1];
        this.maxSize = maxSize;
        this.size = 0;
    }

    public MinHeap() {
        this.heap = new int[maxSize + 1];
    }

    @Override
    public void push(int data) {
        if (size == maxSize) {
            System.err.println("Heap is full");
            return;
        }
        int i = ++size;
        while (i != 1 && data < heap[i / 2]) { // check if we reached the root or not and if
            // child data is less than parent
            heap[i] = heap[i / 2]; // if so change parent to child
            i /= 2;
        }
        heap[i] = data; // insert data to a point either at root
        // or at a position where the child nodes are greater than parent
    }

    @Override
    public int pop() {
        if (size == 0) {
            System.err.println("Heap underflow");
        }
        int parent, child;
        parent = 1;
        child = 2;
        int itemPoped = heap[1];
        int temp = heap[size--];
        while (child <= size) {
            if (heap[child] > heap[child + 1]) {
                child++; // move to the lowest child
            }
            if (temp > heap[child]) {
                heap[parent] = heap[child];
                parent = child;
                child *= 2;
            } else {
                break;
            }
        }
        heap[parent] = temp;
        return itemPoped;
    }

    @Override
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
