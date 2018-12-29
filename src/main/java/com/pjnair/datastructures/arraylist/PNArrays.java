package com.pjnair.datastructures.arraylist;

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


    public static Object[] copyOfRange(Object[] array, int startIndex, int endIndex) {
        if (startIndex > array.length || startIndex < 0 || endIndex > array.length || endIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] result = new Object[endIndex - startIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i + startIndex];
        }
        return result;
    }


}
