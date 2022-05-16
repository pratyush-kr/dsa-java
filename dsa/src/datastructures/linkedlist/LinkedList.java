package datastructures.linkedlist;

public abstract class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = tail = null;
    }

    public abstract void add(int data);

    public abstract void delete(int position);

    public abstract void reverse();

    public abstract void print();

    public abstract void rotate(int k);
}
