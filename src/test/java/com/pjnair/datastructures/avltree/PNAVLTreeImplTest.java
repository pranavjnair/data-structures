package com.pjnair.datastructures.avltree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PNAVLTreeImplTest {

    private PNAVLTreeImpl<Integer> pnavlTree;
    private Integer e1 = 1, e2 = 2, e3 = 3, e4 = 4, e5 = 5;

    @Before
    public void refresh(){
        this.pnavlTree = new PNAVLTreeImpl<>();
    }
    @Test
    public void insert() throws Exception {
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(e1, e2, e3,e4,e5));
        this.pnavlTree.insert(e1);
        this.pnavlTree.insert(e2);
        this.pnavlTree.insert(e3);
        this.pnavlTree.insert(e4);
        this.pnavlTree.insert(e5);
        Assert.assertEquals(expected,this.pnavlTree);
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void search() throws Exception {
    }

    @Test
    public void height() throws Exception {
    }

}