package com.pjnair.datastructures.arraylist;

/**
 * PNArrayList is a custom implementation of ArrayList
 * @param <T>
 */
public interface PNArrayList<T> {
    /**
     * Adds to the end of the ArrayList
     * @param t - element that is added
     */
    void add(T t);

    /**
     * Adds to an index of the ArrayList
     * @param index - the index that the element being added to
     * @param t - element that is added
     * @throws IndexOutOfBoundsException
     */
    void add(int index, T t);

    /**
     * Clears the ArrayList by allocating new memory in constant time complexity
     */
    void clear();

    /**
     * Checks to see if element is in ArrayList
     * @param o - element that is being searched
     * @return boolean
     */
    boolean contains(Object o);

    /**
     * Returns element at location
     * @param index - index in ArrayList being searched
     * @return T - element at index
     * @throws IndexOutOfBoundsException
     */
    T get(int index);

    /**
     * Returns index of object location
     * @param o - object that is being searched
     * @return - returns the index of element
     *         - returns -1 otherwise
     */
    int indexOf(Object o);

    /**
     * Checks if ArrayList is empty
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Removes element at index
     * @param index - index that is bieng removed
     * @throws IndexOutOfBoundsException
     */
    void remove(int index);

    /**
     * Removes first matching object from ArrayList
     * @param o - object that is being searched for
     * @throws java.util.NoSuchElementException
     */
    void remove(Object o);

    /**
     * Replaces element at specific index and returns old element
     * @param index - index where element is being replaced
     * @param t - new element
     * @return - old element
     * @throws IndexOutOfBoundsException
     */
    T set(int index, T t);

    /**
     * Returns the number of Elements in ArrayList
     * @return int
     */
    int size();
}
