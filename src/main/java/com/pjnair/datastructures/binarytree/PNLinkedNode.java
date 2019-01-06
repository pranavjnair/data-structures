package com.pjnair.datastructures.binarytree;

public class PNLinkedNode<T extends Comparable<T>> {
    private PNLinkedNode leftNode, rightNode;
    private T data;

    public PNLinkedNode(T data) {
        this.rightNode = null;
        this.leftNode = null;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public PNLinkedNode getRightNode() {
        return this.rightNode;
    }

    public PNLinkedNode getLeftNode() {
        return this.leftNode;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setRightNode(PNLinkedNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeftNode(PNLinkedNode leftNode) {
        this.leftNode = leftNode;
    }
}
