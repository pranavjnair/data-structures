package com.pjnair.datastructures.hashtable;

public class PNHashTableImpl<K, V> implements PNHashTable<K, V> {

    // private fields
    private int numberOfKeys, initialCapacity = 2;
    private double loadFactorThreshold = 1;
    private PNHashNode<K, V>[] bucketArray;

    /**
     * Constructor 1 for the HashTable
     */
    public HashTable() {
        this.bucketArray = new PNHashNode[initialCapacity];
        this.numberOfKeys = 0;
    }

    /**
     * Constructor 2 for the HashTable
     *
     * @param initialCapacity - capacity for the original
     * @param loadFactorThreshold
     */
    public HashTable(int initialCapacity, double loadFactorThreshold) {
        this.loadFactorThreshold = loadFactorThreshold;
        this.initialCapacity = initialCapacity;
        this.bucketArray = new PNHashNode[initialCapacity];
        this.numberOfKeys = 0;
    }

    /**
     * HashTableADT Implemented Method
     */
    private double getLoadFactorThreshold() {
        return this.loadFactorThreshold; // load factor threshold
    }

    /**
     * HashTableADT Implemented Method
     */
    private double getLoadFactor() {
        // returns the load factor in the HashTable
        return ((double) this.numberOfKeys / (double) this.bucketArray.length);
    }

    /**
     * HashTableADT Implemented Method
     */
    private int getCapacity() {
        return this.bucketArray.length; // returns the capacity of the HashTable
    }

    /**
     * HashTableADT Implemented Method
     */
    private int numKeys() {
        return this.numberOfKeys; // returns the number of keys in the HashTable
    }

    /**
     * HashTableADT Implemented Method
     */
    private int getCollisionResolution() {
        return 1; // Which collision resolution I picked
    }

    /**
     * Hashing Function for the Table
     *
     * @param key - key that hashCode() is called on
     * @param array - Array that algorithm uses to return int
     * @return - index of where key should be placed in array
     */
    private int getLinearProbeBucketIndex(K key, Object[] array) {
        return key.hashCode() % (array.length - 1); // int where key is placed in array
    }

    @Override
    /**
     * DataStructureADT Implemented Method
     */
    public void insert(K key, V value)  {
        if (key == null) {
            return;
        }

        int indexOfBucket = getLinearProbeBucketIndex(key, this.bucketArray); // int of array index
        PNHashNode<K, V> currentNode = this.bucketArray[indexOfBucket]; // current node in IndexOfBucket location

        while (currentNode != null) { // this code bunch checks if there is a duplicate key already in HashTable
            if (currentNode.getKey().equals(key)) {
                return;
            }
            currentNode = currentNode.getNextNode(); // increments currentNode to next node
        }

        PNHashNode<K, V> newNode = new PNHashNode<>(key, value); // new node
        newNode.setNextNode(this.bucketArray[indexOfBucket]); // new node added to linked list
        this.bucketArray[indexOfBucket] = newNode; // new node added to HashTable
        this.numberOfKeys++;

        expandHashTable(); // expands HashTable if needed
    }

    /**
     * expands HashTable if needed
     */
    private void expandHashTable() {

        if (getLoadFactor() >= this.loadFactorThreshold) { // if expand HashTable is needed
            PNHashNode<K, V>[] expandedBucketArray = new PNHashNode[this.bucketArray.length * 2 + 1]; // new size of array
            Iterable<PNHashNode<K,V>> myIterator = new PNHashTableIterator<>(this.bucketArray); // iterates through HashTable

            for (PNHashNode<K,V> i : myIterator){ // Iterator
                if (i != null) {
                    int indexOfBucket = getLinearProbeBucketIndex(i.getKey(), expandedBucketArray); // int of expanded array index

                    PNHashNode<K, V> newNode = new PNHashNode<>(i.getKey(), i.getValue()); // new node for expanded HashTable
                    newNode.setNextNode(expandedBucketArray[indexOfBucket]); // adds to linked list
                    expandedBucketArray[indexOfBucket] = newNode; // adds to HashTable
                }
            }
            this.bucketArray = expandedBucketArray; // makes the bucket array the expanded array
        }
    }

    @Override
    /**
     * DataStructureADT Implemented Method
     */
    public boolean remove(K key) throws IllegalNullKeyException {
        if (key == null) {
            throw new IllegalNullKeyException(); // key can't be null
        }

        int indexOfBucket = getLinearProbeBucketIndex(key, this.bucketArray); // int of expanded array index
        PNHashNode<K, V> currentNode = this.bucketArray[indexOfBucket]; // current Node in linked list
        PNHashNode<K, V> previousNode = null; // previous node in linked list

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                if (previousNode == null) {
                    this.bucketArray[indexOfBucket] = currentNode.getNextNode(); // deletes node
                } else {
                    previousNode.setNextNode(currentNode.getNextNode()); // deletes node
                }
                this.numberOfKeys--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        return false;
    }

    @Override
    /**
     * DataStructureADT Implemented Method
     */
    public V get(K key) throws IllegalArgumentException{
        if (key == null) {
            throw new IllegalArgumentException("key can't be null"); // key can't be null
        }

        int indexOfBucket = getLinearProbeBucketIndex(key, this.bucketArray); // int of array index
        if (indexOfBucket < 0 || indexOfBucket >= this.bucketArray.length) { // index must be in array
            throw new IllegalArgumentException("index not in table");
        }

        PNHashNode<K, V> currentNode = this.bucketArray[indexOfBucket]; // current node in indexOfBucket location

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue(); // found key
            }
            currentNode = currentNode.getNextNode(); // makes currentNode next node
        }

        throw new Key(); // key is not in HashTable
    }
}
