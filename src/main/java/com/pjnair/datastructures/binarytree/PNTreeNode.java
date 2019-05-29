package com.pjnair.datastructures.binarytree;

/**
 * Pranav Nair
 * Lecture 002
 * pjnair@wisc.edu
 * <p>
 * Due date February 24, 2019 10:00 PM
 * Read from Geeksforgeeks and watched youtube videos to remember how to delete and insert a node
 * in a AVL search tree. Took some information from p1 implementation to create my binary search tree
 * <p>
 * was having a problem when running some datastructureadttests with the amount of numKeys in my
 * BST and could not figure out where that problem was coming from. That is the only bug that I
 * know of at time of submission.
 * <p>
 * Classes that use this type:  <BST,ADT>
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
