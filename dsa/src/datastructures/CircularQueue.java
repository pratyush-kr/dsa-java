package datastructures;

import java.util.Scanner;

public class CircularQueue {
    private int n;
    private int[] queue;
    private int rear, front;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public CircularQueue() {
        n = 5;
        queue = new int[n];
        rear = front = -1;
    }

    public CircularQueue(int n) {
        this.n = n;
        queue = new int[n];
        rear = front = -1;
    }

    public void addQ(int data) {
        rear = (rear + 1) % n;
        if (front == rear) {
            System.out.println("Queue overflow");
            if (front == 0) {
                rear = n - 1;
            } else {
                rear = rear - 1;
            }
        } else {
            queue[rear] = data;
            if (front == -1) {
                front = 0;
            }
        }
    }

    public Integer deleteQ() {
        if (front == rear) {
            System.out.println("Queue underflow");
            return null;
        } else {
            int data = queue[front];
            front = (front + 1) % n;
            return data;
        }
    }

    public void print() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void driver() {
        String command = "";
        Scanner sc = new Scanner(System.in);
        CircularQueue cq = new CircularQueue(10);
        while (true) {
            System.out.print("Command: ");
            command = sc.next();
            if (command.compareTo("exit") == 0) {
                break;
            } else if (command.compareTo("add") == 0) {
                int data = sc.nextInt();
                cq.addQ(data);
            } else if (command.compareTo("delete") == 0) {
                cq.deleteQ();
            } else if (command.compareTo("print") == 0) {
                cq.print();
            }
        }
        sc.close();
    }
}
