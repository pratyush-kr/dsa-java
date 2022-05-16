package datastructures;

import datastructures.linkedlist.Node;

public class Queue {
    private Node front;
    private Node back;

    public Queue() {
        front = back = null;
    }

    public void add(int data) {
        if (front == null) {
            front = back = new Node(data);
        } else {
            back.prev = new Node(data);
            back = back.prev;
        }
    }

    public Node remove() {
        try {
            Node ptr = front;
            if (front == null) {
                throw new NullPointerException();
            }
            if (front == back) {
                front = back = null;
            } else {
                front = front.prev;
            }
            return ptr;
        } catch (NullPointerException e) {
            System.err.println(e.toString());
            return null;
        }
    }

    public void printQueue() {
        Node ptr = front;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.prev;
        }
        System.out.println();
    }

    public Node front() {
        return this.back;
    }
}
