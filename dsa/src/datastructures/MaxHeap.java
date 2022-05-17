package datastructures;

import datastructures.Heap.Heap;

public class MaxHeap extends Heap {
    public MaxHeap(int maxSize) {
        this.heap = new int[maxSize + 1];
        this.maxSize = maxSize;
        this.size = 0;
    }

    public MaxHeap() {
        this.heap = new int[maxSize + 1];
    }

    @Override
    public void push(int data) {
        if (size == maxSize) {
            System.err.println("The Heap is full");
            return;
        }
        int i = ++size;
        while (i != 1 && data > heap[i / 2]) {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = data;
    }

    @Override
    public int pop() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
