package com.pjnair.datastructures.heap;

public interface PNMinHeap<T> {
    void enqueue(T t);
    T dequeue();
    T peek();
    int size();
    boolean isEmpty();
}
