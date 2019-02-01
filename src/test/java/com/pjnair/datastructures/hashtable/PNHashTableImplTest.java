package com.pjnair.datastructures.hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PNHashTableImplTest {

    PNHashTableImpl<String, Integer> pnHashTable;

    @Before
    public void refresh() {
        pnHashTable = new PNHashTableImpl<>();
    }

    @Test
    public void clear() throws Exception {
        pnHashTable.add("a", 1);
        pnHashTable.clear();
        Assert.assertEquals(true, pnHashTable.isEmpty());
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(true, pnHashTable.isEmpty());
    }

    @Test
    public void get1() throws Exception {
        Assert.assertEquals(null, pnHashTable.get("a"));
    }

    @Test
    public void remove() throws Exception {
        pnHashTable.add("a", 1);
        Assert.assertEquals(new Integer(1), pnHashTable.remove("a"));
    }

    @Test
    public void add1() throws Exception {
        pnHashTable.add("a", 1);
        Assert.assertEquals(new Integer(1), pnHashTable.get("a"));
    }

    @Test
    public void add2() throws Exception {
        pnHashTable.add("a", 1);
        pnHashTable.add("b", 2);
        pnHashTable.add("c", 3);
        pnHashTable.add("d", 4);
        pnHashTable.add("e", 5);
        pnHashTable.add("f", 6);
        Assert.assertEquals(new Integer(1), pnHashTable.get("a"));
    }


}