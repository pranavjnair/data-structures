package com.pjnair.datastructures.hashtable;

import java.util.ArrayList;

public class PNHashTableImpl<K, V> implements PNHashTable<K, V> {
    private ArrayList<PNHashNode<K, V>> nodeArrayList;

    private static int capacityArrayList, sizeArrayList;

    private static final int CAPACITY = 5;

    public PNHashTableImpl() {
        this.nodeArrayList = new ArrayList<>(CAPACITY);
        capacityArrayList = CAPACITY;
        sizeArrayList = 0;
    }

    @Override
    public void clear() {
        this.nodeArrayList = new ArrayList<>(capacityArrayList);
    }

    @Override
    public boolean isEmpty() {
        if (sizeArrayList == 0) {
            return true;
        }
        return false;
    }

    private int getNodeIndex(K key) { // Hash function
        int hashCode = key.hashCode();
        int index = hashCode % capacityArrayList;
        return index;
    }

    @Override
    public V get(K key) {
        int nodeIndex = getNodeIndex(key);
        PNHashNode<K, V> head = nodeArrayList.get(nodeIndex);
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNextNode();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int bucketIndex = getNodeIndex(key);
        PNHashNode<K, V> head = nodeArrayList.get(bucketIndex);
        PNHashNode<K, V> prev = null;
        while (head != null) {
            if (head.getKey().equals(key)) {
                break;
            }
            prev = head;
            head = head.getNextNode();
        }
        if (head == null) { // key was never found
            return null;
        }
        if (prev != null) { // previous node exists
            prev.setNextNode(head.getNextNode());
        } else {
            nodeArrayList.set(bucketIndex, head.getNextNode());
        }
        sizeArrayList--;
        return head.getValue();
    }

    @Override
    public void add(K key, V value) {
        int nodeIndex = getNodeIndex(key);
        PNHashNode<K, V> head = nodeArrayList.get(nodeIndex);
        while (head != null) { // Checks if element already exists in Hashtable
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            }
            head = head.getNextNode();
        }
        head = nodeArrayList.get(nodeIndex); // sets element back to head reference of linked list
        PNHashNode<K, V> newNode = new PNHashNode<>(key, value);
        newNode.setNextNode(head);
        nodeArrayList.set(nodeIndex, newNode); // makes the head the new node
        sizeArrayList++;
        expandHashTable();
    }

    private void expandHashTable() {
        if ((sizeArrayList / capacityArrayList) >= 0.75) {
            ArrayList<PNHashNode<K, V>> temp = nodeArrayList;
            capacityArrayList = 2 * capacityArrayList;
            sizeArrayList = 0;
            nodeArrayList = new ArrayList<>(capacityArrayList);
            for (PNHashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNextNode();
                }
            }
        }
    }
}
