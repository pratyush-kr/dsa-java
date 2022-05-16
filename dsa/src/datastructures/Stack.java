package datastructures;

import datastructures.linkedlist.Node;

public class Stack {
    private Node top;
    private Node bottom;

    public Stack() {
        top = bottom = null;
    }

    public void push(int data) {
        if (top == null) {
            top = new Node(data);
            bottom = top;
        } else {
            Node ptr = new Node(data);
            ptr.next = top;
            top = ptr;
        }
    }

    public void printStack() {
        Node ptr = top;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public Node peek() {
        return top;
    }

    public Node pop() {
        Node ptr = top;
        try {
            if (top == bottom) {
                top = bottom = null;
            } else {
                top = top.next;
            }
        } catch (NullPointerException e) {
            System.err.println(e.toString());
        }
        return ptr;
    }
}
