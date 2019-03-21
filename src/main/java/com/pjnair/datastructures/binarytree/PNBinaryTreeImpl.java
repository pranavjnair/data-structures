package com.pjnair.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PNBinaryTreeImpl<T extends Comparable<T>> implements PNBinaryTree<T> {

    private PNLinkedNode<T> head;

    public PNBinaryTreeImpl() {
        this.head = null;
    }

    @Override
    public void insert(T t) {
        if (isEmpty()) {
            this.head = new PNLinkedNode<>(t);
        } else {
            insertNode(this.head, t);
        }
    }

    private void insertNode(PNLinkedNode<T> currentNode, T t) {
        if (currentNode.getData().compareTo(t) > 0) {
            if (currentNode.getLeftNode() == null) {
                currentNode.setLeftNode(new PNLinkedNode(t));
            } else {
                insertNode(currentNode.getLeftNode(), t);
            }
        } else if (currentNode.getData().compareTo(t) < 0) {
            if (currentNode.getRightNode() == null) {
                currentNode.setRightNode(new PNLinkedNode(t));
            } else {
                insertNode(currentNode.getRightNode(), t);
            }
        }
    }

    @Override
    public void remove(T t) throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            this.head = removeNode(this.head, t);
        }
    }

    private PNLinkedNode<T> removeNode(PNLinkedNode<T> currentNode, T t) throws NoSuchElementException {
        if (currentNode == null) {
            return null;
        }
        int compare = currentNode.getData().compareTo(t);
        if (compare > 0) { // checks left side
            if (currentNode.getLeftNode() != null) {
                currentNode.setLeftNode(removeNode(currentNode.getLeftNode(), t));
            } else {
                throw new NoSuchElementException();
            }
        } else if (compare < 0) { // checks right side
            if (currentNode.getRightNode() != null) {
                currentNode.setRightNode(removeNode(currentNode.getRightNode(), t));
            } else {
                throw new NoSuchElementException();
            }
        } else {
            if (currentNode.getLeftNode() == null) {
                return currentNode.getRightNode();
            } else if (currentNode.getRightNode() == null) {
                return currentNode.getLeftNode();
            } else {
                PNLinkedNode<T> minNodeOfRightSubTree = minimumElement(currentNode.getRightNode());
                remove(minNodeOfRightSubTree.getData());
                currentNode.setData(minNodeOfRightSubTree.getData());
            }
        }
        return currentNode;
    }

    private PNLinkedNode<T> minimumElement(PNLinkedNode<T> currentNode) {
        if (currentNode.getLeftNode() != null) {
            return minimumElement(currentNode.getLeftNode());
        }
        return currentNode;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean search(T t) {
        if (isEmpty()) {
            return false;
        } else {
            return searchNode(this.head, t);
        }
    }

    private boolean searchNode(PNLinkedNode<T> currentNode, T t) {
        if (currentNode == null) {
            return false;
        }
        int compare = currentNode.getData().compareTo(t);
        if (compare == 0) {
            return true;
        } else if (compare > 0) {
            return searchNode(currentNode.getLeftNode(), t);
        } else {
            return searchNode(currentNode.getRightNode(), t);
        }
    }

    @Override
    public int height() {
        if (!isEmpty()) {
            return treeHeight(this.head);
        }
        return -1;
    }

    private int treeHeight(PNLinkedNode<T> currentNode) {
        if (currentNode == null) {
            return -1;
        } else {
            int leftSide = treeHeight(currentNode.getLeftNode());
            int rightSide = treeHeight(currentNode.getRightNode());
            if (leftSide > rightSide) {
                return (leftSide + 1);
            } else {
                return (rightSide + 1);
            }
        }
    }

    public List<T> getAllData() {
        List<T> result = new ArrayList<>();
        if (!isEmpty()) {
            getAllDataSorted(this.head, result);
        }
        return result;
    }

    private void getAllDataSorted(PNLinkedNode<T> currentNode, List<T> allData) {
        if (currentNode != null) {
            getAllDataSorted(currentNode.getLeftNode(), allData);
            allData.add(currentNode.getData());
            getAllDataSorted(currentNode.getRightNode(), allData);
        }
    }

}
