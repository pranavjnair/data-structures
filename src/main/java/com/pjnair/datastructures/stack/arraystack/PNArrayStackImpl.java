package com.pjnair.datastructures.stack.arraystack;

import com.pjnair.datastructures.stack.PNStack;

public class PNArrayStackImpl<T> implements PNStack<T> {
    private final int INITIAL_SIZE = 5;
    private T[] array;
    private int size;

    public PNArrayStackImpl() {
        array = (T[]) new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public void push(T item) {
        extendArray();
        this.array[this.size] = item;
        this.size++;
    }

    private void extendArray() {
        if (size >= this.array.length) {
            this.array = (T[]) PNArrays.copyOf(this.array, this.array.length * 2);
        }
    }

    @Override
    public T pop() {
        T result = this.array[this.size - 1];
        this.array[this.size - 1] = null;
        this.size--;
        return result;
    }

    @Override
    public T peek() {
        return this.array[this.size - 1];
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int search(Object o) {
        int result = -1;
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.array[i] == o) {
                result = this.size - i;
                break;
            }
        }
        return result;
    }
}
