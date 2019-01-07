package com.pjnair.datastructures.heap;

public class PNMinHeapImpl<T extends Comparable<T>> implements PNMinHeap<T> {

    private final int INITIAL_CAPACITY = 5;

    private T[] minHeap;

    private int size;

    public PNMinHeapImpl() {
        this.minHeap = (T[]) new Comparable[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public void enqueue(T t) {
        int indexOfNewObject = 0;
        expandCapacity();
        for (int i = 1; i < this.minHeap.length; i++) {
            if (this.minHeap[i] == null) {
                this.minHeap[i] = t;
                indexOfNewObject = i;
                break;
            }
        }
        minHeapPercolateUp(indexOfNewObject);
        this.size++;
    }

    private void minHeapPercolateUp(int index) {
        if (index != 0 && index != 1 && this.minHeap[index].compareTo(this.minHeap[index / 2]) < 0) {
            T buffer = this.minHeap[index / 2];
            this.minHeap[index / 2] = this.minHeap[index];
            this.minHeap[index] = buffer;
            minHeapPercolateUp(index / 2);
        }
    }


    private void expandCapacity() {
        if (this.size + 1 >= this.minHeap.length) {
            this.minHeap = (T[]) PNArrays.copyOf(this.minHeap, this.minHeap.length * 2);
        }
    }

    @Override
    public T dequeue() {
        T result = null;
        if (!isEmpty()) {
            result = this.minHeap[1];
            this.minHeap[1] = this.minHeap[this.size];
            this.minHeap[this.size] = null;
            this.size--;
            if (this.size > 0) {
                minHeapPercolateDown(1);
            }
        }
        return result;
    }

    private void minHeapPercolateDown(int index) {
        Integer leftChildIndex, rightChildIndex, minIndex;
        leftChildIndex = index * 2;
        rightChildIndex = (index * 2) + 1;
        if (leftChildIndex <= this.size && rightChildIndex <= this.size) {
            if (this.minHeap[leftChildIndex].compareTo(this.minHeap[rightChildIndex]) < 0) {
                minIndex = leftChildIndex;
            } else {
                minIndex = rightChildIndex;
            }
            swap(minIndex, index);
        } else if (leftChildIndex <= this.size) {
            minIndex = leftChildIndex;
            swap(minIndex, index);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        if (this.minHeap[firstIndex].compareTo(this.minHeap[secondIndex]) < 0) {
            T buffer = this.minHeap[secondIndex]; // swapper helper
            this.minHeap[secondIndex] = this.minHeap[firstIndex]; // swap
            this.minHeap[firstIndex] = buffer; // swap
            minHeapPercolateDown(secondIndex); // recursive call
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return this.minHeap[1];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
