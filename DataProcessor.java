package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class DataProcessor {

    private int numberOfOperations;
    private BinarySearchTree list;

    DataProcessor(int numberOfOperations, BinarySearchTree list) {
        this.numberOfOperations = numberOfOperations;
        this.list = list;
    }

    public void fillRandom() {
        for (int i = 0; i < numberOfOperations; i++) {
            int val = ThreadLocalRandom.current().nextInt(numberOfOperations);
            list.insert(val);
        }
    }

    public void fillSorted() {
        for (int i = 0; i < numberOfOperations; i++) {
            list.insert(i);
        }
    }

    public void delete() {
        for (int i = 0; i < numberOfOperations; i++) {
            list.delete(i);
        }
    }

    public long timeInsertRandom() {
        long startTime = System.nanoTime();
        fillRandom();
        return (System.nanoTime() - startTime) / 1000;
    }

    public long timeInsertSorted() {
        long startTime = System.nanoTime();
        fillSorted();
        return (System.nanoTime() - startTime) / 1000;
    }

    public long timeDelete() {
        long startTime = System.nanoTime();
        delete();
        return (System.nanoTime() - startTime) / 1000;
    }

    public long timeContains() {
        long startTime = System.nanoTime();
        int val = ThreadLocalRandom.current().nextInt(numberOfOperations);
        list.contains(val);
        return (System.nanoTime() - startTime) / 1000;
    }

    public long timeBalancing() {
        long startTime = System.nanoTime();
        list.balanceRecursive(list.getRoot());
        return (System.nanoTime() - startTime) / 1000;
    }
}
