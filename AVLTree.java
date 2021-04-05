package com.company;

public class AVLTree extends BinarySearchTree {


    private Node root;


    public AVLTree() {

    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void insert(int element) {
        root = insert(root, element);
        rebalance(root);
    }

    @Override
    public void delete(int element) {
        root = delete(root, element);
        if (root != null) {
            rebalance(root);
        }
    }
}
