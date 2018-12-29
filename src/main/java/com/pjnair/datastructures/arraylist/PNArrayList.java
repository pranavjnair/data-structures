package com.pjnair.datastructures.arraylist;

/**
 *
 * @param <T>
 */
public interface PNArrayList<T> {
    void add(T t);

    void add(int index, T t);

    void clear();

    boolean contains(Object o);

    T get(int index);

    boolean isEmpty();

    void remove(int index);

    void remove(Object o);

    T set(int index, T t);

    int size();
}
