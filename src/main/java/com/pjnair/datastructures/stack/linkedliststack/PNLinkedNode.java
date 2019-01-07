package com.pjnair.datastructures.stack.linkedliststack;

public class PNLinkedNode<T> {
    private T data;
    private PNLinkedNode<T> previousNode;

    public PNLinkedNode(T data, PNLinkedNode<T> previousNode) {
        this.data = data;
        this.previousNode = previousNode;
    }

    public PNLinkedNode<T> getPreviousNode() {
        return this.previousNode;
    }

    public T getData() {
        return this.data;
    }

}
