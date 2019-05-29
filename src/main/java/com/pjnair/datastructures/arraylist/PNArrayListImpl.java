package com.pjnair.datastructures.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of ArrayList Data Structure
 * @param <T>
 */
public class PNArrayListImpl<T> implements PNArrayList<T>, Iterable<T> {

    private T[] array;
    private int size, currentIndex;
    private final int INITIAL_SIZE = 20;

    public PNArrayListImpl() {
        this.array = (T[]) new Object[INITIAL_SIZE];
        this.size = 0;
        this.currentIndex = 0;
    }

    public PNArrayListImpl(int size) {
        this.array = (T[]) new Object[size];
        this.size = 0;
        this.currentIndex = 0;
    }

    private void expandArray() {
        if (this.size >= this.array.length) {
            this.array = (T[]) PNArrays.copyOf(this.array, this.array.length * 2);
        }
    }

    @Override
    public void add(T t) {
        expandArray();
        this.array[this.size] = t;
        this.size++;
    }

    @Override
    public void add(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T[] leftArray = (T[]) PNArrays.copyOfRange(this.array, 0, index);
        T[] rightArray = (T[]) PNArrays.copyOfRange(this.array, index, this.array.length);
        T[] resultArray = (T[]) combineArrays(leftArray, t, rightArray);
        this.array = resultArray;
        this.size++;
    }

    private Object[] combineArrays(Object[] leftArray, T t, Object[] rightArray) {
        Object[] result = (T[]) new Object[this.array.length + 1];
        for (int i = 0; i < leftArray.length; i++) {
            result[i] = leftArray[i];
        }
        result[leftArray.length] = t;
        for (int i = 1; i < rightArray.length; i++) {
            result[i + leftArray.length + 1] = rightArray[i];
        }
        return result;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[this.array.length];
        this.size = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object obj : this.array) {
            if (obj == o || obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++){
            if (this.array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T[] leftArray = (T[]) PNArrays.copyOfRange(this.array, 0, index);
        T[] rightArray = (T[]) PNArrays.copyOfRange(this.array, index, this.array.length);
        this.array = (T[]) combineArrays(leftArray, rightArray);
        this.size--;
    }

    private Object[] combineArrays(Object[] leftArray, Object[] rightArray) {
        Object[] result = (T[]) new Object[this.array.length - 1];
        for (int i = 0; i < leftArray.length; i++) {
            result[i] = leftArray[i];
        }
        for (int i = 1; i < rightArray.length; i++) {
            result[i + leftArray.length - 1] = rightArray[i];
        }
        return result;
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == o || this.array[i].equals(o)) {
                T[] leftArray = (T[]) PNArrays.copyOfRange(this.array, 0, i);
                T[] rightArray = (T[]) PNArrays.copyOfRange(this.array, i, this.array.length);
                this.array = (T[]) combineArrays(leftArray, rightArray);
                this.size--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public T set(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = this.array[index];
        this.array[index] = t;
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> result = new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return (currentIndex < size && array[currentIndex] != null);
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
        return result;
    }

    @Override
    public String toString() {
        return "PNArrayListImpl{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", currentIndex=" + currentIndex +
                ", INITIAL_SIZE=" + INITIAL_SIZE +
                '}';
    }
}
