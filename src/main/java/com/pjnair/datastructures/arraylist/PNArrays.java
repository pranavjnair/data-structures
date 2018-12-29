package com.pjnair.datastructures.arraylist;

public class PNArrays<T> {

    public static Object[] copyOf(Object[] array, int size) {
        Object[] result = new Object[size];
        for (int i = 0;i<array.length;i++){
            result[i] = array[i];
        }
        return result;
    }


    public static Object[] copyOfRange(Object[] array, int startIndex, int endIndex) {
        Object[] result = new Object[endIndex - startIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i+startIndex];
        }
        return result;
    }


}
