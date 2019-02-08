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
    public void remove(T t) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            this.head = removeNode(this.head, t);
        }
    }

    private PNLinkedNode removeNode(PNLinkedNode<T> currentNode, T t) {
        if (currentNode == null) {
            return null;
        }
        int compare = currentNode.getData().compareTo(t);
        if (compare > 0) {
            currentNode.setLeftNode(removeNode(currentNode.getLeftNode(), t));
        } else if (compare < 0) {
            currentNode.setRightNode(removeNode(currentNode.getRightNode(), t));
        } else {
            if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                return null;
            } else if (currentNode.getLeftNode() == null) {
                return currentNode.getRightNode();
            } else if (currentNode.getRightNode() == null) {
                return currentNode.getLeftNode();
            } else {
                T minValue = (T) minimumElement(currentNode.getRightNode());
                currentNode.setData(minValue);
                currentNode.setRightNode(removeNode(currentNode.getRightNode(), minValue));
            }
        }
        return currentNode;
    }

    private Object minimumElement(PNLinkedNode<T> currentNode) {
        if (currentNode.getLeftNode() != null) {
            return minimumElement(currentNode.getLeftNode());
        }
        return currentNode.getData();
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
            throw new NoSuchElementException();
        } else {
            return searchNode(this.head, t);
        }
    }

    private boolean searchNode(PNLinkedNode<T> currentNode, T t) {
        boolean result = false;
        int compare = currentNode.getData().compareTo(t);
        if (compare == 0) {
            result = true;
        } else if (compare > 0 && currentNode.getLeftNode() != null) {
            result = searchNode(currentNode.getLeftNode(), t);
        } else if (compare < 0 && currentNode.getRightNode() != null) {
            result = searchNode(currentNode.getRightNode(), t);
        }
        return result;
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
