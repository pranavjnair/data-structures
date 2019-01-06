package com.pjnair.datastructures.binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PNBinaryTreeImplTest {

    PNBinaryTreeImpl<Integer> pnBinaryTree;
    Integer e1 = 1, e2 = 2, e3 = 3, e4 = 4, e5 = 5;

    @Before
    public void refresh() {
        pnBinaryTree = new PNBinaryTreeImpl<>();
    }

    @Test
    public void insert() throws Exception {
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(e1, e2, e3));
        pnBinaryTree.insert(e1);
        pnBinaryTree.insert(e1);
        pnBinaryTree.insert(e3);
        System.out.println(pnBinaryTree.getAllData());
        assertEquals(expected, pnBinaryTree.getAllData());
    }

    @Test
    public void remove() throws Exception {
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(e1, e2, e3, e5));
        pnBinaryTree.insert(e2);
        pnBinaryTree.insert(e4);
        pnBinaryTree.insert(e1);
        pnBinaryTree.insert(e3);
        pnBinaryTree.insert(e5);
        pnBinaryTree.remove(e4);
        assertEquals(expected, pnBinaryTree.getAllData());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, pnBinaryTree.isEmpty());
    }

    @Test
    public void search() throws Exception {
        pnBinaryTree.insert(e2);
        pnBinaryTree.insert(e4);
        pnBinaryTree.insert(e1);
        pnBinaryTree.insert(e3);
        pnBinaryTree.insert(e5);
        assertEquals(true, pnBinaryTree.search(e3));
    }

    @Test
    public void height() throws Exception {
        pnBinaryTree.insert(e2);
        pnBinaryTree.insert(e4);
        pnBinaryTree.insert(e1);
        pnBinaryTree.insert(e3);
        pnBinaryTree.insert(e5);
        assertEquals(2, pnBinaryTree.height());
    }

}