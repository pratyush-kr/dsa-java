package datastructures;

import datastructures.trees.Node;

public class AvlTree extends Tree {
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            root.height = 0;
            return root;
        } else if (data < root.data) {
            root.left = insert(root.left, data);
            if (root.left.height - root.right.height == 2) {
                if (data < root.left.data) {
                    root = singleRightRotate(root);
                } else {
                    root = doubleRightRotate(root);
                }
            }
        } else if (data > root.data) {
            root.right = insert(root.right, data);
            if (root.left.height - root.right.height == 2) {
                if (data > root.right.data) {
                    root = singleLeftRotate(root);
                } else {
                    root = doubleLeftRotate(root);
                }
            }
        }
        root.height = (root.left.height > root.right.height) ? root.left.height + 1 : root.right.height + 1;
        return root;
    }

    private Node singleRightRotate(Node root) {
        Node tmp = root.left;
        root.left = tmp.right;
        tmp.right = root;
        root.height = (root.left.height > root.right.height) ? root.left.height + 1 : root.right.height + 1;
        tmp.height = (tmp.left.height > tmp.right.height) ? tmp.left.height + 1 : tmp.right.height + 1;
        return tmp;
    }

    private Node doubleRightRotate(Node root) {
        root.left = singleLeftRotate(root.left);
        return singleLeftRotate(root);
    }

    private Node singleLeftRotate(Node root) {
        Node tmp = root.right;
        root.right = tmp.left;
        tmp.left = root;
        root.height = (root.left.height > root.right.height) ? root.left.height + 1 : root.right.height + 1;
        tmp.height = (tmp.left.height > tmp.right.height) ? tmp.left.height + 1 : tmp.right.height + 1;
        return tmp;
    }

    private Node doubleLeftRotate(Node root) {
        root.left = singleLeftRotate(root.left);
        return singleLeftRotate(root);
    }
}
