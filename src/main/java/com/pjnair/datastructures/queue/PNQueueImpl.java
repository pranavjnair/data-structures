package com.pjnair.datastructures.queue;

public class PNQueueImpl<T> implements PNQueue<T> {

    private PNLinkedNode<T> head, tail;

    public PNQueueImpl() {
        this.head = null;
        this.tail = this.head;
    }

    @Override
    public void add(T t) {
        if (this.head == null) {
            this.head = new PNLinkedNode<>(t, null);
            this.tail = this.head;
        } else {
            this.tail.setNextNode(new PNLinkedNode<>(t, null));
            this.tail = this.tail.getNextNode(); //reset tail
        }
    }

    @Override
    public T poll() {
        T result = null;
        if (this.head == null) {
            return result;
        } else if (this.head == this.tail) {
            result = this.head.getData();
            this.head = this.tail = null;
        } else {
            result = this.head.getData();
            this.head = this.head.getNextNode();
        }
        return result;
    }

    @Override
    public T peek() {
        if (this.head == null) {
            return null;
        } else {
            return this.head.getData();
        }
    }
}
