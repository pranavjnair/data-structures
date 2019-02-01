package com.pjnair.datastructures.hashtable;

public class PNHashTableImpl<K, V> implements PNHashTable<K, V> {

    private PNHashNode[] pnHashNodes;

    private final int INITIAL_CAPACITY = 5;

    private static int capacityArray = 0;

    public PNHashTableImpl() {
        this.pnHashNodes = new PNHashNode[INITIAL_CAPACITY];
        for (int i = 0; i < pnHashNodes.length; i++) {
            this.pnHashNodes[i] = null;
        }
    }

    @Override
    public void clear() {
        this.pnHashNodes = new PNHashNode[this.pnHashNodes.length];
        capacityArray = 0;
        for (int i = 0; i < pnHashNodes.length; i++) {
            this.pnHashNodes[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (capacityArray == 0) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        PNHashNode<K, V> currentNode = pnHashNodes[getHashedIndex(key)];
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        PNHashNode<K, V> currentNode = pnHashNodes[getHashedIndex(key)];
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                PNHashNode<K,V> bufferNode = currentNode;
                currentNode = currentNode.getNextNode();
                return bufferNode.getValue();

            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        PNHashNode currentNode = null;
        if (this.pnHashNodes[getHashedIndex(key)] == null) {
            this.pnHashNodes[getHashedIndex(key)] = new PNHashNode(key, value);
        } else {
            currentNode = this.pnHashNodes[getHashedIndex(key)];
            while (currentNode.getNextNode() != null) {
                if (currentNode.getValue().equals(value)) { // checks if key already exists
                    return;
                }
                currentNode = currentNode.getNextNode(); // increment
            }
            currentNode.setNextNode(new PNHashNode(key, value)); // adds to end of linked list
        }
        if (((1.0 * capacityArray) / pnHashNodes.length) >= .7) {
            this.pnHashNodes = (PNHashNode[]) PNArrays.copyOf(this.pnHashNodes, this.pnHashNodes.length * 2);
        }
    }

    private int getHashedIndex(K key) {
        return (key.hashCode() % this.pnHashNodes.length);
    }
}
