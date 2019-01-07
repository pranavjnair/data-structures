package com.pjnair.datastructures.stack.arraystack;

public class PNArrays<T> {

    public static Object[] copyOf(Object[] array, int newSize) {
        if (newSize <= array.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] result = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

}
