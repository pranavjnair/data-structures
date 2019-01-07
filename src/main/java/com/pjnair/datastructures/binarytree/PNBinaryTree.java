package com.pjnair.datastructures.binarytree;

public interface PNBinaryTree<T> {
    void insert(T t);
    void remove(T t);
    boolean isEmpty();
    boolean search(T t);
    int height();
}
