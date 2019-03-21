package com.pjnair.datastructures.binarytree;

import java.util.NoSuchElementException;

public interface PNBinaryTree<T> {
    void insert(T t);
    void remove(T t) throws NoSuchElementException;
    boolean isEmpty();
    boolean search(T t);
    int height();
}
