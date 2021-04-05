package com.company;

public class BinarySearchTree {

    protected class Node {
        int element;
        int height;
        Node left;
        Node right;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node root;

    public BinarySearchTree() {

    }

    public Node getRoot() {
        return root;
    }

    public void insert(int element) {
        root = insert(root, element);
    }

    protected Node insert(Node current, int element) {
        if (current == null) {
            return new Node(element);
        }

        if (element < current.element) {
            current.left = insert(current.left, element);
        } else if (element > current.element) {
            current.right = insert(current.right, element);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public boolean contains(int element) {
        return contains(root, element);
    }

    protected boolean contains(Node current, int element) {
        if (current == null) {
            return false;
        }
        if (element == current.element) {
            return true;
        }
        return element < current.element
                ? contains(current.left, element)
                : contains(current.right, element);
    }

    public void delete(int element) {
        root = delete(root, element);
    }

    protected Node delete(Node current, int element) {
        if (current == null) {
            return null;
        }

        if (element == current.element) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.element = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;
        }
        if (element < current.element) {
            current.left = delete(current.left, element);
            return current;
        }
        current.right = delete(current.right, element);
        return current;
    }

    public void balanceRecursive(Node root) {
        if (root != null) {
            balanceRecursive(rebalance(root.left));
            balanceRecursive(rebalance(root.right));
        }
    }

    protected Node rebalance(Node z) {
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        };
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.element : findSmallestValue(root.left);
    }


    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.element);
            traverseInOrder(node.right);
        }
    }
}
