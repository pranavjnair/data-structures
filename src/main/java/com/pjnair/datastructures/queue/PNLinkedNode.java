package com.pjnair.datastructures.queue;

public class PNLinkedNode<T> {
    private T data;
    private PNLinkedNode<T> nextNode;

    public PNLinkedNode(T data, PNLinkedNode<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public PNLinkedNode<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(PNLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return this.data;
    }

}
