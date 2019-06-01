package com.pjnair.datastructures.tree.avltree;

/**
 * Pranav Nair
 */

import com.pjnair.datastructures.tree.binarytree.*;
import com.pjnair.datastructures.tree.PNTreeNode;

/**
 * Implementation of AVL using a key and a value
 *
 * @param <K> - key in BST
 * @param <V> - value in BST
 */
public class PNAVLTreeImpl<K extends Comparable<K>, V> extends PNBinaryTreeImpl<K, V> {

    /**
     * Inserts node into Search Tree
     *
     * @param key   - key to insert
     * @param value - value to insert
     */
    @Override
    public void insert(K key, V value) throws NullPointerException {
        if (key == null){
            throw new NullPointerException();
        } else if (isEmpty()) {
            this.root = new PNTreeNode<>(key, value, null, null);
        } else {
            this.root = insertNode(this.root, key, value);
        }
    }

    /**
     * Inserts node into Search Tree
     *
     * @param currentNode - current node in Search Tree
     * @param key         - key to insert
     * @param value       - value to insert
     */
    private PNTreeNode<K, V> insertNode(PNTreeNode<K, V> currentNode, K key, V value){
        if (currentNode == null) {
            currentNode = new PNTreeNode<>(key, value, null, null); // adds node to Search Tree
        } else {
            int compare = key.compareTo(currentNode.key); // compares key to currentNode.key
            if (compare < 0) {
                currentNode.left = insertNode(currentNode.left, key, value); // recursive call on left node
            } else {
                currentNode.right = insertNode(currentNode.right, key, value); // recursive call on right node
            }
        }
        return balance(currentNode); // balances Search Tree from currentNode
    }

    /**
     * Removes node from Search Tree
     *
     * @param key - key to remove
     * @return - returns Search Tree with node removed
     */
    @Override
    public boolean remove(K key) throws NullPointerException {
        if (key == null) {
            throw new NullPointerException(); // key can not be null
        } else if (isEmpty()) {
            return false; // key does not exist
        } else {
            if (contains(key)) {
                this.root = removeHelper(key, this.root); // removes node from Search Tree
                this.numKeys--; // decrements numKeys
                return true; // return value
            } else {
                return false; // key does not exist
            }
        }
    }

    /**
     * Removes node from Search Tree
     *
     * @param currentNode - current node in Search Tree
     * @param key         - key to remove
     * @return - returns Search Tree with node removed
     */
    private PNTreeNode<K, V> removeHelper(K key, PNTreeNode<K, V> currentNode) {
        if (currentNode == null) {
            return null; // return value
        }
        int compare = key.compareTo(currentNode.key); // compares key to currentNode.key
        if (compare < 0) {
            currentNode.left = removeHelper(key, currentNode.left); // recursive call on left node
        } else if (compare > 0) {
            currentNode.right = removeHelper(key, currentNode.right); // recursive call on right node
        } else {
            if (currentNode.left == null) {
                return currentNode.right; // return value
            } else if (currentNode.right == null) {
                return currentNode.left; // return value
            } else {
                if (height(currentNode.left) >= height(currentNode.right)) { // remove from left sub tree
                    PNTreeNode<K, V> maxNodeOfLeftSubTree = findMaxNode(currentNode.left); // finds node to remove
                    currentNode.key = maxNodeOfLeftSubTree.key;
                    currentNode.value = maxNodeOfLeftSubTree.value;
                    currentNode.left = removeHelper(maxNodeOfLeftSubTree.key, currentNode.left); // removes node
                } else { // remove from right sub tree
                    PNTreeNode<K, V> minNodeOfRightSubTree = findMinNode(currentNode.right); // finds node to remove
                    currentNode.key = minNodeOfRightSubTree.key;
                    currentNode.value = minNodeOfRightSubTree.value;
                    currentNode.right = removeHelper(minNodeOfRightSubTree.key, currentNode.right); // removes node
                }
            }
        }
        return balance(currentNode); // return value
    }

    /**
     * Finds the max node from current node
     *
     * @param currentNode - current node in Search Tree
     * @return - returns max node from original current node
     */
    private PNTreeNode<K, V> findMaxNode(PNTreeNode<K, V> currentNode) {
        if (currentNode.right != null) {
            return findMaxNode(currentNode.right); // recursive call on right node
        }
        return currentNode; // return value
    }

    /**
     * Finds the max node from current node
     *
     * @param currentNode - current node in Search Tree
     * @return - returns min node from original current node
     */
    private PNTreeNode<K, V> findMinNode(PNTreeNode<K, V> currentNode) {
        if (currentNode.left != null) {
            return findMinNode(currentNode.left); // recursive call from left node
        }
        return currentNode; // return value
    }

    /**
     * Balances from current node
     *
     * @param currentNode - current node in Search Tree
     * @return - current node after balance
     */
    private PNTreeNode<K, V> balance(PNTreeNode<K, V> currentNode) {
        int balanceFactor = nodeBalanceFactor(currentNode); // finds balance factor from current node
        if (balanceFactor > 1) {
            if (nodeBalanceFactor(currentNode.left) < 0) { // left right case
                currentNode.left = leftRotate(currentNode.left); // step 1
                currentNode = rightRotate(currentNode); // step 2
            } else { // left left case
                currentNode = rightRotate(currentNode); // 1 step
            }
        } else if (balanceFactor < -1) {
            if (nodeBalanceFactor(currentNode.right) > 0) { // right left case
                currentNode.right = rightRotate(currentNode.right); // step 1
                currentNode = leftRotate(currentNode); // step 2
            } else { // right right case
                currentNode = leftRotate(currentNode); // 1 step
            }
        }
        return currentNode; // return value
    }

    /**
     * Facilitates a right rotate from current node
     *
     * @param currentNode - current node in Search Tree
     * @return - current node after rotate
     */
    private PNTreeNode<K, V> rightRotate(PNTreeNode<K, V> currentNode) {
        PNTreeNode root = currentNode.left; // step 1
        currentNode.left = root.right; // step 2
        root.right = currentNode; // step 3
        return root; // return value
    }

    /**
     * Facilitates a left rotate from current node
     *
     * @param currentNode - current node in Search Tree
     * @return - current node after rotate
     */
    private PNTreeNode<K, V> leftRotate(PNTreeNode<K, V> currentNode) {
        PNTreeNode<K, V> root = currentNode.right; // step 1
        currentNode.right = root.left; // step 2
        root.left = currentNode; // step 3
        return root; // return value
    }

    /**
     * Returns the balance factor from the current node
     *
     * @param currentNode - current node in Search Tree
     * @return - balance factor from original node
     */
    private int nodeBalanceFactor(PNTreeNode<K, V> currentNode) {
        if (!isEmpty()) {
            return nodeBalanceFactorHelper(currentNode.left) - nodeBalanceFactorHelper(currentNode.right); // return value
        }
        return 0; // return value
    }

    /**
     * Returns the balance factor from the current node
     *
     * @param currentNode - current node in Search Tree
     * @return - balance factor from current node
     */
    private int nodeBalanceFactorHelper(PNTreeNode<K, V> currentNode) {
        if (currentNode == null) {
            return 0; // return value
        } else {
            int leftSide = nodeBalanceFactorHelper(currentNode.left); // left side
            int rightSide = nodeBalanceFactorHelper(currentNode.right); // right side
            if (leftSide >= rightSide) {
                return (leftSide + 1); // return value
            } else {
                return (rightSide + 1); // return value
            }
        }
    }

    /**
     * Returns the height from the current node
     *
     * @param currentNode - current node in Search Tree
     * @return - height from the current node
     */
    private int height(PNTreeNode<K, V> currentNode) {
        if (!isEmpty()) {
            return heightHelper(currentNode); // return recursive call from current node
        }
        return 0; // return value
    }

    private int heightHelper(PNTreeNode<K, V> currentNode) {
        if (currentNode == null) {
            return 0; // return value
        } else {
            int leftSide = heightHelper(currentNode.left); // left side
            int rightSide = heightHelper(currentNode.right); // right side
            if (leftSide >= rightSide) {
                return (leftSide + 1); // return value
            } else {
                return (rightSide + 1); // return value
            }
        }
    }
}


