package com.pjnair.datastructures.hashtable;

import java.util.Iterator;

public class PNHashNode<K, V> {

    private K key;
    private V value;
    private PNHashNode<K, V> nextNode;

    public PNHashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.nextNode = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setNextNode(PNHashNode<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public PNHashNode<K, V> getNextNode() {
        return nextNode;
    }

}
