package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import datastructures.trees.Node;

public class Tree {
    public Node root;

    public void levelOrderInsertion() {
        int data;
        String strData;
        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            System.out.print("root: ");
            data = sc.nextInt();
            root = new Node(data);
        }
        queue.add(root);
        while (queue.isEmpty() == false) {
            Node curr = queue.remove();
            System.out.print(curr.data + "'s left child: ");
            strData = sc.next();
            if (strData.compareTo("exit") == 0) {
                break;
            }
            if (strData.compareTo("null") != 0) {
                data = Integer.parseInt(strData);
                curr.left = new Node(data);
                queue.add(curr.left);
            }
            System.out.print(curr.data + "'s right child: ");
            strData = sc.next();
            if (strData.compareTo("exit") == 0) {
                break;
            }
            if (strData.compareTo("null") != 0) {
                data = Integer.parseInt(strData);
                curr.right = new Node(data);
                queue.add(curr.right);
            }
        }
        sc.close();
    }

    public void printLevelOrder() {
        if (root == null) {
            return;
        }
        Node curr = root;
        System.out.print(curr.data + " ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(curr);
        while (queue.isEmpty() == false) {
            Node tmp = queue.remove();
            if (tmp.left == null) {
                System.out.print("null ");
            } else {
                System.out.print(tmp.left.data + " ");
                queue.add(tmp.left);
            }
            if (tmp.right == null) {
                System.out.print("null ");
            } else {
                System.out.print(tmp.right.data + " ");
                queue.add(tmp.right);
            }
        }

    }

    public void printInorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        printInorderRecursive(root.left);
        System.out.print(root.data + " ");
        printInorderRecursive(root.right);
    }

    public void printPreorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreorderRecursive(root.left);
        printPreorderRecursive(root.right);
    }

    public void printPostorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        printPostorderRecursive(root.left);
        printPostorderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public void printInorderIterative(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else if (stack.isEmpty() == false) {
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                break;
            }
        }
    }

    public void printPreorderIterative(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (true) {
            if (curr != null) {
                System.out.print(curr.data + " ");
                stack.push(curr);
                curr = curr.left;
            } else if (stack.isEmpty() == false) {
                curr = stack.pop();
                curr = curr.right;
            } else {
                break;
            }
        }
    }

    public void printPostorderIterative(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (true) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            if (stack.isEmpty() == true) {
                return;
            }
            curr = stack.pop();
            if (stack.size() > 0 && stack.peek() == curr) {
                curr = curr.right;
            } else {
                System.out.print(curr.data + " ");
                curr = null;
            }
        }
    }

    public int countLeaf(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == root.right && root.left == null) {
            return 1;
        } else {
            return countLeaf(root.right) + countLeaf(root.left);
        }
    }

    public void swapTree(Node root) {
        if (root == null) {
            return;
        } else {
            swapTree(root.left);
            swapTree(root.right);
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
}