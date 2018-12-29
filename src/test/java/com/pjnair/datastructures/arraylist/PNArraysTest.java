package com.pjnair.datastructures.arraylist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PNArraysTest {

    Integer[] pnArray;

    @Before
    public void refreshPNArray(){
        pnArray = new Integer[]{0,1,2,3,4,5,6,7,8,9};
    }

    @Test
    public void copyOf() throws Exception {
        Object[] pnArrayCopy = PNArrays.copyOf(this.pnArray,this.pnArray.length*2);
        assertEquals(2 * this.pnArray.length, pnArrayCopy.length);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void copyOfBoundary() throws Exception {
        Object[] pnArrayCopy = PNArrays.copyOf(this.pnArray,this.pnArray.length/2);
    }

    @Test
    public void copyOfRange() throws Exception {
        Object[] pnArrayCopy = PNArrays.copyOfRange(this.pnArray,0,1);
        assertEquals(1,pnArrayCopy.length);
    }

}