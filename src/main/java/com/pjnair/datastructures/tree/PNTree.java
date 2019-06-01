package com.pjnair.datastructures.tree;

import java.util.List;

public interface PNTree<K,V> {
    /**
     * Add the key,value pair to the data structure and increase the number of keys
     * If key is null, throw NullPointerException;
     * If key is already in data structure, does nothing;
     */
    void insert(K key, V value) throws NullPointerException;

    /**
     * If key is found, remove the key,value pair from the data structure and decrease num keys.
     * If key is null, throw NullPointerException
     * If key is not found, does nothing.
     */
    boolean remove(K key) throws NullPointerException;

    /**
     * Returns the value associated with the specified key
     * If key is null, throw NullPointerException
     * If key is not found, returns null.
     */
    V get(K key) throws NullPointerException;

    /**
     * Returns true if the key is in the data structure
     * If key is null, throw NullPointerException
     */
    boolean contains(K key) throws NullPointerException;

    /**
     * Returns the number of key,value pairs in the data structure
     * @return number of keys in tree
     */
    int numKeys();

    /**
     * Returns the height of this BST.
     * H is defined as the number of levels in the tree.
     * @return height of tree
     */
    int getHeight();

    /**
     * Returns the keys of the data structure in sorted order.
     *
     * @return List of Keys in-order
     */
    List<K> getInOrderTraversal();

    /**
     * Returns the keys of the data structure in pre-order traversal order.
     *
     * @return List of Keys in pre-order
     */
    List<K> getPreOrderTraversal();

    /**
     * Returns the keys of the data structure in post-order traversal order.
     *
     * @return List of Keys in post-order
     */
    List<K> getPostOrderTraversal();

    /**
     * Returns the keys of the data structure in level-order traversal order.
     *
     * @return List of Keys in level-order
     */
    List<K> getLevelOrderTraversal();
}
