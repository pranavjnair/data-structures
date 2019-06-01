package com.pjnair.datastructures.tree;

/**
 * Pranav Nair
 */

public class PNTreeNode<K, V> {

    // instance fields
    public K key;
    public V value;
    public PNTreeNode<K, V> left;
    public PNTreeNode<K, V> right;

    /**
     * @param key        - key of PNTreeNode
     * @param value      - value of PNTreeNode
     * @param leftChild  - left child of PNTreeNode
     * @param rightChild - right child of PNTreeNode
     */
    public PNTreeNode(K key, V value, PNTreeNode<K, V> leftChild, PNTreeNode<K, V> rightChild) {
        this.key = key;
        this.value = value;
        this.left = leftChild;
        this.right = rightChild;
    }

}
