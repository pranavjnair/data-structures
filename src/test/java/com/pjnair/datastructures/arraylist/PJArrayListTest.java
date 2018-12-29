package com.pjnair.datastructures.arraylist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class PJArrayListTest {

    PNArrayListImpl<Integer> pjArrayList = null;
    Integer e1 = 1, e2 = 2, e3 = 3, e4 = null;

    @Before
    public void init() {
        pjArrayList = new PNArrayListImpl<>();
    }

    @Test
    public void add() throws Exception {
        pjArrayList.add(e1);
        Assert.assertTrue(pjArrayList.get(0).equals(e1));
    }

    @Test
    public void addAtIndex() throws Exception {
        pjArrayList.add(e1);
        pjArrayList.add(e2);
        pjArrayList.add(1, e3);
        Assert.assertTrue(pjArrayList.get(1).equals(e3));
    }

    @Test
    public void clear() throws Exception {
        pjArrayList.add(e1);
        pjArrayList.add(e1);
        pjArrayList.add(e1);
        pjArrayList.add(e1);
        pjArrayList.add(e1);
        pjArrayList.clear();
        Assert.assertEquals(0, pjArrayList.size());
    }

    @Test
    public void contains() throws Exception {
        pjArrayList.add(e1);
        pjArrayList.add(e3);
        pjArrayList.add(e4);
        Assert.assertTrue(pjArrayList.contains(e4));
    }

    @Test
    public void get() throws Exception {
        pjArrayList.add(e1);
        pjArrayList.add(e4);
        pjArrayList.add(e3);
        pjArrayList.add(e2);
        Assert.assertTrue(pjArrayList.get(2) == e3);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(pjArrayList.size() == 0);
    }

    @Test
    public void iteratorEmpty() throws Exception {
        Iterator iterator = pjArrayList.iterator();
        Assert.assertEquals(false, iterator.hasNext());
    }

    @Test
    public void iteratorTest() throws Exception {
        pjArrayList.add(e1);
        pjArrayList.add(e2);
        Iterator iterator = pjArrayList.iterator();
        Assert.assertEquals(true, iterator.hasNext());
    }

    @Test
    public void remove() throws Exception {
        pjArrayList.add(e1);
        pjArrayList.add(e2);
        pjArrayList.remove(0);
        Assert.assertTrue(pjArrayList.get(0) == e2);
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