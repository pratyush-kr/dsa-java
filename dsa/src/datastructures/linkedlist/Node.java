package datastructures.linkedlist;

public class Node {
    public Node prev;
    public int data;
    public Node next;

    public Node() {
        prev = next = null;
        data = 0;
    }

    public Node(int data) {
        prev = next = null;
        this.data = data;
    }
}
