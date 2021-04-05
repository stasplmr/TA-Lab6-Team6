package com.company;

public class Main {

    public static void main(String[] args) {
	    BinarySearchTree rbst = new BinarySearchTree();
        DataProcessor dp1 = new DataProcessor(10000, rbst);

        System.out.println("----Unbalanced Tree----");
        System.out.println("random");
        System.out.println("Insertion: " + dp1.timeInsertRandom());
        System.out.println("Balancing: " + dp1.timeBalancing());

        System.out.println("\nsorted");
        System.out.println("Insertion: " + dp1.timeInsertSorted());
        System.out.println("Balancing: " + dp1.timeBalancing());

        BinarySearchTree rbst1 = new BinarySearchTree();
        DataProcessor dp01 = new DataProcessor(10000, rbst1);
        dp01.timeInsertRandom();
        System.out.println("\nSearch: " + dp01.timeContains());
        System.out.println("Deletion: " + dp01.timeDelete());


        AVLTree avlt = new AVLTree();
        DataProcessor dp2 = new DataProcessor(10000, avlt);
        System.out.println("\n----AVL Tree----");
        System.out.println("random");
        System.out.println("Insertion: " + dp2.timeInsertRandom());
        System.out.println("Balancing: " + dp2.timeBalancing());

        System.out.println("\nsorted");
        System.out.println("Insertion: " + dp2.timeInsertSorted());
        System.out.println("Balancing: " + dp2.timeBalancing());

        AVLTree avlt1 = new AVLTree();
        DataProcessor dp02 = new DataProcessor(10000, avlt1);
        dp02.timeInsertRandom();
        System.out.println("\nSearch: " + dp02.timeContains());
        System.out.println("Deletion: " + dp02.timeDelete());

    }
}
