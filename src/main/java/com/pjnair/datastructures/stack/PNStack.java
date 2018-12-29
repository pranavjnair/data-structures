package com.pjnair.datastructures.stack;

public interface PNStack<T> {
    void push(T o);

    T pop();

    T peek();

    boolean isEmpty();

    int search(Object o);
}
