package com.pjnair.datastructures.arraylist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class PJArrayListTest {

    PNArrayListImpl<Integer> pnArrayList = null;
    Integer e1 = 1, e2 = 2, e3 = 3, e4 = null;

    @Before
    public void refresh() {
        pnArrayList = new PNArrayListImpl<>();
    }

    @Test
    public void add() throws Exception {
        pnArrayList.add(e1);
        Assert.assertTrue(pnArrayList.get(0).equals(e1));
    }

    @Test
    public void addAtIndex() throws Exception {
        pnArrayList.add(e1);
        pnArrayList.add(e2);
        pnArrayList.add(1, e3);
        Assert.assertTrue(pnArrayList.get(1).equals(e3));
    }

    @Test
    public void clear() throws Exception {
        pnArrayList.add(e1);
        pnArrayList.add(e1);
        pnArrayList.add(e1);
        pnArrayList.add(e1);
        pnArrayList.add(e1);
        pnArrayList.clear();
        Assert.assertEquals(0, pnArrayList.size());
    }

    @Test
    public void contains() throws Exception {
        pnArrayList.add(e1);
        pnArrayList.add(e3);
        pnArrayList.add(e4);
        Assert.assertTrue(pnArrayList.contains(e4));
    }

    @Test
    public void get() throws Exception {
        pnArrayList.add(e1);
        pnArrayList.add(e4);
        pnArrayList.add(e3);
        pnArrayList.add(e2);
        Assert.assertTrue(pnArrayList.get(2) == e3);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(pnArrayList.size() == 0);
    }

    @Test
    public void iteratorEmpty() throws Exception {
        Iterator iterator = pnArrayList.iterator();
        Assert.assertEquals(false, iterator.hasNext());
    }

    @Test
    public void iteratorTest() throws Exception {
        pnArrayList.add(e1);
        pnArrayList.add(e2);
        Iterator iterator = pnArrayList.iterator();
        Assert.assertEquals(true, iterator.hasNext());
    }

    @Test
    public void remove() throws Exception {
        pnArrayList.add(e1);
        pnArrayList.add(e2);
        pnArrayList.remove(0);
        Assert.assertTrue(pnArrayList.get(0) == e2);
    }

    @Test
    public void remove1() throws Exception {
    }

    @Test
    public void set() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }
}