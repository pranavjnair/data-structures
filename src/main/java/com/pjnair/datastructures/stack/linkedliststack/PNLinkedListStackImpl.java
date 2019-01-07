package com.pjnair.datastructures.stack.linkedliststack;

import com.pjnair.datastructures.stack.PNStack;

public class PNLinkedListStackImpl<T> implements PNStack<T> {

    private PNLinkedNode<T> tail;

    public PNLinkedListStackImpl() {
        this.tail = null;
    }

    @Override
    public void push(T o) {
        this.tail = new PNLinkedNode<>(o, this.tail);
    }

    @Override
    public T pop() {
        T result = this.tail.getData();
        this.tail = this.tail.getPreviousNode();
        return result;
    }

    @Override
    public T peek() {
        return this.tail.getData();
    }

    @Override
    public boolean isEmpty() {
        if (this.tail == null) {
            return true;
        }
        return false;
    }

    @Override
    public int search(Object o) {
        int result = -1;
        PNLinkedNode currentNode = this.tail;
        int currentNodeCount = 1;
        while (currentNode != null) {
            if (currentNode.getData() == o) {
                result = currentNodeCount;
                break;
            }
            currentNode = currentNode.getPreviousNode();
            currentNodeCount++;
        }
        return result;
    }
}
