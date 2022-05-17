package datastructures;

import datastructures.heap.Heap;

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
        int parent, child;
        int item, temp;
        if (size == 0) {
            return heap[0];
        }
        item = heap[1];
        temp = heap[size--];
        parent = 1;
        child = 2;
        while (child <= size) {
            if (child < size && heap[child] < heap[child + 1]) {
                child++;
            }
            if (temp < heap[child]) {
                heap[parent] = heap[child];
                parent = child;
                child *= 2;
            } else {
                break;
            }
        }
        heap[parent] = temp;
        return item;
    }

    @Override
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
