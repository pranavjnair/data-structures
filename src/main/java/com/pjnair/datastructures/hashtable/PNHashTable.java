package com.pjnair.datastructures.hashtable;

public interface PNHashTable<K,V> {
    void clear();
    boolean isEmpty();
    V get(K key);
    V remove(K key);
    void add(K key, V value);
}
