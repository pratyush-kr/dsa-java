package datastructures;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

public class SinglyLinkedList extends LinkedList {
    @Override
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node temp = new Node(data);
            tail.next = temp;
            tail = temp;
        }
    }

    @Override
    public void delete(int position) {
        Node ptr = head, prev = null, next = null;
        int i = 0, n = 0;
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }
        ptr = head;
        position = position % n;
        if (position == 0) {
            head = head.next;
            return;
        }
        while (ptr != null && i < position) {
            prev = ptr;
            ptr = ptr.next;
            i++;
        }
        next = ptr.next;
        prev.next = next;
        ptr = null;
    }

    @Override
    public void reverse() {
        Node ptr = head;
        Node prev = null;
        Node next = null;
        while (ptr != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        Node tmp = head;
        head = tail;
        tail = tmp;
    }

    @Override
    public void print() {
        Node ptr = head.next;
        System.out.print("[" + head.data + "]");
        while (ptr != null) {
            System.out.print("->[" + ptr.data + "]");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public void rotate(int k) {
        Node ptr = head;
        int i = 0;
        int n = 0;
        while (ptr != null) {
            ptr = ptr.next;
            n++;
        }
        k = k % n;
        if (k == 0) {
            return;
        }
        ptr = head;
        while (i < n - k - 1) {
            ptr = ptr.next;
            i++;
        }
        Node newHead = ptr.next;
        Node mid = newHead;
        while (mid.next != null) {
            mid = mid.next;
        }
        mid.next = head;
        ptr.next = null;
        head = newHead;
        tail = ptr;
    }
}
