package datastructures.Heap;

import java.util.ArrayList;

public interface Heap {
    public ArrayList<Integer> heap = new ArrayList<>();

    public abstract void push(int data);

    public abstract void pop();
}
