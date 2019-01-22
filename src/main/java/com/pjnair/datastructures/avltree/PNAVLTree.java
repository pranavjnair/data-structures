package com.pjnair.datastructures.avltree;

public interface PNAVLTree<T> {
    void insert(T t);
    void remove(T t);
    boolean isEmpty();
    boolean search(T t);
    int height();
}
