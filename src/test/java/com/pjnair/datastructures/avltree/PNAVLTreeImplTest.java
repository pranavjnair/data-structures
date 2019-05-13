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

    @Before
    public void refresh(){
        this.pnavlTree = new PNAVLTreeImpl<>();
    }
    @Test
    public void insert() throws Exception {
        this.pnavlTree.insert(new Integer(1));
        this.pnavlTree.insert(new Integer(2));
        this.pnavlTree.insert(new Integer(3));
        this.pnavlTree.insert(new Integer(4));
        this.pnavlTree.insert(new Integer(5));
        this.pnavlTree.printLevelOrder();
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