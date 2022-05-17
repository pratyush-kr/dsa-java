package datastructures.heap;

public abstract class Heap {
    protected int[] heap = null;
    protected int size = 0;
    protected int maxSize = 100;

    public abstract void push(int data);

    public abstract int pop();

    public abstract void print();
}
