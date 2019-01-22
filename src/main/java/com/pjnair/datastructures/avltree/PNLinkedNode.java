package com.pjnair.datastructures.avltree;

public class PNLinkedNode<T> {
    private PNLinkedNode<T> leftNode, rightNode;
    private T data;

    PNLinkedNode(T data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public T getData() {
        return this.data;
    }

    public PNLinkedNode<T> getLeftNode() {
        return leftNode;
    }

    public PNLinkedNode<T> getRightNode() {
        return rightNode;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setRightNode(PNLinkedNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeftNode(PNLinkedNode<T> leftNode) {
        this.leftNode = leftNode;
    }
}
