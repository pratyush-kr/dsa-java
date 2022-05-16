package datastructures;

import datastructures.Heap.Heap;

public class MaxHeap implements Heap {
    public MaxHeap() {
        heap.add(-1);
    }

    @Override
    public void push(int data) {

        int i = heap.size() + 1;
        while (i != 1 && data > heap.get(i / 2)) {
            heap.set(i, heap.get(i / 2));
            i /= 2;
        }
        heap.set(i, data);
    }

    @Override
    public void pop() {
        if (heap.size() == 0) {
            System.err.println("Heap is empty");
            return;
        }
        int item = heap.get(1);
        int temp = heap.get(heap.size() - 1);
        int parent = 1;
        int child = 2;
        while (child <= heap.size()) {
        }

    }

}
