package com.pjnair.datastructures.tree.binarytree;

/**
 * Pranav Nair
 */

import com.pjnair.datastructures.tree.PNTree;
import com.pjnair.datastructures.tree.PNTreeNode;

import java.util.ArrayList; // allowed for creating traversal lists
import java.util.List; // required for returning List<K>

/**
 * Implementation of BST using a key and a value
 *
 * @param <K> - key in BST
 * @param <V> - value in BST
 */
public class PNBinaryTreeImpl<K extends Comparable<K>, V> implements PNTree<K, V> {

    protected PNTreeNode<K, V> root;
    protected int numKeys; // number of keys in BST

    public PNBinaryTreeImpl() {
        this.root = null;
        this.numKeys = 0;
    }

    @Override
    public List<K> getPreOrderTraversal() {
        ArrayList<K> preOrderTraversalArrayList = new ArrayList<>(); // creates ArrayList
        if (isEmpty()) {
            return preOrderTraversalArrayList; // returns empty ArrayList
        }
        return getPreOrderTraversalHelper(preOrderTraversalArrayList, this.root); // returns ArrayList with pre order traversal
    }

    /**
     * Traverses Search Tree using pre order traversal and returns an ArrayList
     *
     * @param preOrderTraversalArrayList - ArrayList that contains the pre order traversal
     * @param currentNode                - current node that is being looked at in search tree
     * @return - returns ArrayList containing pre order traversal
     */
    private ArrayList<K> getPreOrderTraversalHelper(ArrayList<K> preOrderTraversalArrayList,
                                                    PNTreeNode<K, V> currentNode) {
        preOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        if (currentNode.left != null) {
            getPreOrderTraversalHelper(preOrderTraversalArrayList, currentNode.left); // recursive call on left node
        }
        if (currentNode.right != null) {
            getPreOrderTraversalHelper(preOrderTraversalArrayList, currentNode.right); // recursive call on right node
        }
        return preOrderTraversalArrayList; // return ArrayList
    }

    @Override
    public List<K> getPostOrderTraversal() {
        ArrayList postOrderTraversalArrayList = new ArrayList<>(); // creates ArrayList
        if (isEmpty()) {
            return postOrderTraversalArrayList; // returns empty ArrayList
        }
        return getPostOrderTraversalHelper(postOrderTraversalArrayList, this.root); // returns ArrayList with post order traversal
    }

    /**
     * Traverses Search Tree using post order traversal and returns an ArrayList
     *
     * @param postOrderTraversalArrayList - ArrayList that contains the post order traversal
     * @param currentNode                 - current node that is being looked at in search tree
     * @return - returns ArrayList containing post order traversal
     */
    private ArrayList<K> getPostOrderTraversalHelper(ArrayList<K> postOrderTraversalArrayList, PNTreeNode<K, V> currentNode) {
        if (currentNode == null) {
            return postOrderTraversalArrayList; // return value
        }
        if (currentNode == this.root) {
            getPostOrderTraversalHelper(postOrderTraversalArrayList, currentNode.left); // recursive call on left node
            getPostOrderTraversalHelper(postOrderTraversalArrayList, currentNode.right); // recursive call on right node
            postOrderTraversalArrayList.add(this.root.key); // adds root node key to ArrayList
            return postOrderTraversalArrayList; // return ArrayList
        } else if (currentNode.left != null && currentNode.right != null) {
            getPostOrderTraversalHelper(postOrderTraversalArrayList, currentNode.left); // recursive call on left node
            getPostOrderTraversalHelper(postOrderTraversalArrayList, currentNode.right); // recursive call on right node
            postOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        } else if (currentNode.left != null && currentNode.right == null) {
            getPostOrderTraversalHelper(postOrderTraversalArrayList, currentNode.left); // recursive call on left node
            postOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        } else if (currentNode.left == null && currentNode.right != null) {
            getPostOrderTraversalHelper(postOrderTraversalArrayList, currentNode.right); // recursive call on right node
            postOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        } else {
            postOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        }
        return postOrderTraversalArrayList; // return ArrayList
    }

    @Override
    public List<K> getLevelOrderTraversal() {
        ArrayList<K> levelOrderTraversalArrayList = new ArrayList<>(); // creates ArrayList
        if (isEmpty()) {
            return levelOrderTraversalArrayList; // returns empty ArrayList
        }
        int h = this.getHeight(); // gets height of the BST
        for (int i = 0; i <= h; i++) {
            levelOrderTraversalArrayList = getLevelOrderTraversalHelper(levelOrderTraversalArrayList, this.root, i); // adds to ArrayList for each level i
        }
        return levelOrderTraversalArrayList; // returns ArrayList with level order traversal
    }

    /**
     * Traverses Search Tree using level order traversal and returns ArrayList
     *
     * @param levelOrderTraversalArrayList - ArrayList that contains the level order traversal
     * @param currentNode                  - current node that is being looked at in search tree
     * @param level                        - current level that is being looked at in search tree
     * @return - returns ArrayList containing level order traversal
     */
    private ArrayList<K> getLevelOrderTraversalHelper(ArrayList<K> levelOrderTraversalArrayList, PNTreeNode<K, V> currentNode, int level) {
        if (currentNode == null) {
            return levelOrderTraversalArrayList; // breaks recursive call when currentNode == null
        } else if (level == 0) {
            levelOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        } else if (level > 0) {
            getLevelOrderTraversalHelper(levelOrderTraversalArrayList, currentNode.left, level - 1); // recursive call on left node
            getLevelOrderTraversalHelper(levelOrderTraversalArrayList, currentNode.right, level - 1); // recursive call on right node
        }
        return levelOrderTraversalArrayList; // return ArrayList
    }

    @Override
    public List<K> getInOrderTraversal() {
        ArrayList<K> inOrderTraversalArrayList = new ArrayList<>(); // creates ArrayList
        if (isEmpty()) {
            return inOrderTraversalArrayList; // returns empty ArrayList
        }
        return getInOrderTraversalHelper(inOrderTraversalArrayList, this.root); // returns ArrayList with in order traversal
    }

    /**
     * Traverses Search Tree using in order traversal and returns ArrayList
     *
     * @param inOrderTraversalArrayList - ArrayList that contains the in order traversal
     * @param currentNode               - current node that is being looked at in search tree
     * @return - returns ArrayList containing in order traversal
     */
    private ArrayList<K> getInOrderTraversalHelper(ArrayList<K> inOrderTraversalArrayList, PNTreeNode<K, V> currentNode) {
        if (currentNode.left != null && currentNode.right != null) {
            getInOrderTraversalHelper(inOrderTraversalArrayList, currentNode.left); // recursive call on left node
            inOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
            getInOrderTraversalHelper(inOrderTraversalArrayList, currentNode.right); // recursive call on right node
        } else if (currentNode.left != null && currentNode.right == null) {
            getInOrderTraversalHelper(inOrderTraversalArrayList, currentNode.left); // recursive call on left node
            inOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        } else if (currentNode.left == null && currentNode.right != null) {
            inOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
            getInOrderTraversalHelper(inOrderTraversalArrayList, currentNode.right); // recursive call on right node
        } else {
            inOrderTraversalArrayList.add(currentNode.key); // adds node key to ArrayList
        }
        return inOrderTraversalArrayList; // return ArrayList
    }

    @Override
    public void insert(K key, V value) throws NullPointerException {
        if (key == null) {
            throw new NullPointerException(); // key can not be null
        } else if (isEmpty()) {
            this.root = new PNTreeNode<K, V>(key, value, null, null); // root becomes a new node
            this.numKeys++; // increments numKeys
        } else {
            insertHelper(this.root, key, value); // recursive call inserts node
        }
    }

    /**
     * Inserts node into Search Tree
     *
     * @param currentNode - current node in Search Tree
     * @param key         - key to insert
     * @param value       - value to insert
     */
    private void insertHelper(PNTreeNode<K, V> currentNode, K key, V value) {
        int compare = key.compareTo(currentNode.key); // compares key to currentNode.key
        if (compare > 0) {
            if (currentNode.right == null) {
                currentNode.right = new PNTreeNode<K, V>(key, value, null, null); // adds node to search tree
                this.numKeys++; // increments numKeys
            } else {
                insertHelper(currentNode.right, key, value); // recursive call on right node
            }
        } else if (compare < 0){
            if (currentNode.left == null) {
                currentNode.left = new PNTreeNode<K, V>(key, value, null, null); // adds node to search tree
                this.numKeys++; // increments numKeys
            } else {
                insertHelper(currentNode.left, key, value); // recursive call on left node
            }
        }
    }

    @Override
    public boolean remove(K key) throws NullPointerException {
        if (key == null) {
            throw new NullPointerException(); // key can not be null
        } else if (isEmpty()) {
            return false; // key doesn't exist in Search Tree
        } else {
            if (contains(key)) {
                this.root = removeHelper(this.root, key); // removes node from Search Tree
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
    private PNTreeNode<K, V> removeHelper(PNTreeNode<K, V> currentNode, K key) throws NullPointerException {
        int compare = key.compareTo(currentNode.key); // compares key to currentNode.key
        if (compare > 0) {
            currentNode.right = removeHelper(currentNode.right, key); // recursive call on right node
        } else if (compare < 0) {
            currentNode.left = removeHelper(currentNode.left, key); // recursive call on left node
        } else {
            if (currentNode.left == null) { // case 1
                return currentNode.right;
            } else if (currentNode.right == null) { // case 2
                return currentNode.left;
            } else {
                PNTreeNode<K, V> minNodeOfRightSubTree = getMinNode(currentNode.right); // gets minimum node right of currentNode
                remove(minNodeOfRightSubTree.key); // removes min node
                currentNode.value = minNodeOfRightSubTree.value; // changes value of current node
                currentNode.key = minNodeOfRightSubTree.key; // changes key of current node
            }
        }
        return currentNode; // return value
    }

    /**
     * Returns the minimum node from the current node
     *
     * @param currentNode - current node in Search Tree
     * @return - returns minimum node
     */
    private PNTreeNode<K, V> getMinNode(PNTreeNode<K, V> currentNode) {
        if (currentNode.left != null) {
            return getMinNode(currentNode.left); // recursive call on left node
        }
        return currentNode; // return current node
    }

    @Override
    public V get(K key) throws NullPointerException {
        if (key == null) {
            throw new NullPointerException(); // key can not be null
        } else if (isEmpty()) {
            return null; // key does not exist
        } else {
            return getHelper(key, this.root); // return recursive call from root
        }
    }

    /**
     * Gets node in search tree that contains key
     *
     * @param key         - key that is being searched for
     * @param currentNode - current node in Search Tree
     * @return - returns the value of the key in Search Tree
     */
    private V getHelper(K key, PNTreeNode<K, V> currentNode) {
        int compare = key.compareTo(currentNode.key); // compares key to currentNode.key
        if (compare > 0) {
            if (currentNode.right != null) {
                return getHelper(key, currentNode.right); // recursive call on right node
            } else {
                return null; // key does not exist
            }
        } else if (compare < 0) {
            if (currentNode.left != null) {
                return getHelper(key, currentNode.left); // recursive call on left node
            } else {
                return null; // key does not exist
            }
        } else {
            return currentNode.value; // returns value of current node
        }
    }

    @Override
    public boolean contains(K key) throws NullPointerException {
        if (key == null) {
            throw new NullPointerException(); // key can not be null
        } else if (isEmpty()) {
            return false; // does not contain key
        } else {
            return containsHelper(key, this.root); // return recursive call from root
        }
    }

    /**
     * Checks if Search Tree contains key
     *
     * @param key         - key that is being looked for
     * @param currentNode - current node in Search Tree
     * @return - true of Search Tree contains key or false if Search Tree doesn't contain key
     */
    private boolean containsHelper(K key, PNTreeNode<K, V> currentNode) {
        int compare = key.compareTo(currentNode.key); // compares key to currentNode.key
        if (compare > 0) {
            if (currentNode.right != null) {
                return containsHelper(key, currentNode.right); // recursive call on right node
            } else {
                return false; // return value
            }
        } else if (compare < 0) {
            if (currentNode.left != null) {
                return containsHelper(key, currentNode.left); // recursive call on left node
            } else {
                return false; // return value
            }
        } else {
            return true; // return value
        }
    }

    @Override
    public int numKeys() {
        return this.numKeys;
    }

    @Override
    public int getHeight() {
        return getHeightHelper(this.root); // return recursive call for height
    }

    /**
     * Gets height from root
     *
     * @param currentNode - currentNode in Search Tree
     * @return - returns height from root
     */
    private int getHeightHelper(PNTreeNode<K, V> currentNode) {
        if (currentNode == null) {
            return 0; // return value
        } else {
            int leftSide = getHeightHelper(currentNode.left); // left side
            int rightSide = getHeightHelper(currentNode.right); // right side
            if (leftSide >= rightSide) {
                return (leftSide + 1); // return value
            } else {
                return (rightSide + 1); // return value
            }
        }
    }

    /**
     * checks if Search Tree is empty
     * protected method as it is used in AVL and BST Search Trees
     *
     * @return true if Search Tree is empty and false if not
     */
    protected boolean isEmpty() {
        if (this.root == null) {
            return true; // return value
        } else {
            return false; // return value
        }
    }

}

