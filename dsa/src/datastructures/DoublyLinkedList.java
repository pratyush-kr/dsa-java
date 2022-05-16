package datastructures;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

public class DoublyLinkedList extends LinkedList {

    @Override
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node tmp = new Node(data);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
    }

    @Override
    public void delete(int position) {

    }

    @Override
    public void reverse() {
        Node ptr = head;
        while (ptr != null) {
            Node tmp = ptr.next;
            ptr.next = ptr.prev;
            ptr.prev = tmp;
            ptr = tmp;
        }
        Node tmp = head;
        head = tail;
        tail = tmp;
    }

    @Override
    public void print() {
        System.out.print("[" + head.data + "]");
        Node ptr = head.next;
        while (ptr != null) {
            System.out.print("<->[" + ptr.data + "]");
            ptr = ptr.next;
        }
        System.out.println();
    }

    @Override
    public void rotate(int k) {
        int n = 0;
        Node ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            n++;
        }
        k = k % n;
        if (k == 0) {
            return;
        }
        int i = 0;
        ptr = head;
        while (i < n - k - 1) {
            ptr = ptr.next;
            i++;
        }
        Node newHead = ptr.next;
        Node newTail = ptr;
        Node mid = newHead;
        while (mid.next != null) {
            mid = mid.next;
        }
        mid.next = head;
        head.prev = mid;
        newTail.next = null;
        newHead.prev = null;
        head = newHead;
        tail = newTail;
    }

}
