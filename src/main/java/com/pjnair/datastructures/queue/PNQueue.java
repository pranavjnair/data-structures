package com.pjnair.datastructures.queue;

public interface PNQueue<T> {
    void add(T t);
    T poll();
    T peek();
}
