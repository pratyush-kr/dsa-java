package datastructures.trees;

public class Node {
    public Node left;
    public int data;
    public int height;
    public Node right;

    public Node() {
        left = right = null;
        data = 0;
    }

    public Node(int data) {
        left = right = null;
        this.data = data;
    }
}
