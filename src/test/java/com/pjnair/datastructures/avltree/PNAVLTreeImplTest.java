package com.pjnair.datastructures.avltree;

/**
 * Pranav Nair
 * Lecture 002
 * pjnair@wisc.edu
 * <p>
 * Due date February 24, 2019 10:00 PM
 * Read from Geeksforgeeks and watched youtube videos to remember how to delete and insert a node
 * in a AVL search tree. Took some information from p1 implementation to create my binary search tree
 * <p>
 * was having a problem when running some datastructureadttests with the amount of numKeys in my
 * BST and could not figure out where that problem was coming from. That is the only bug that I
 * know of at time of submission.
 */

import com.pjnair.datastructures.arraylist.PNArrayListImpl;
import com.pjnair.datastructures.binarytree.PNBinaryTreeImpl;
import com.pjnair.datastructures.binarytree.PNBinaryTreeImplTest;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

//@SuppressWarnings("rawtypes")
public class PNAVLTreeImplTest {

    PNAVLTreeImpl<String, String> avl;
    PNAVLTreeImpl<Integer, String> avl2;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void refresh() throws Exception {
        avl = new PNAVLTreeImpl<>();
        avl2 = new PNAVLTreeImpl<>();
    }


    @Test
    void testAVL_001_insert_sorted_order_simple() {
        try {
            avl2.insert(10, "10");
            if (!avl2.getKeyAtRoot().equals(10))
                fail("avl insert at root does not work");

            avl2.insert(20, "20");
            if (!avl2.getKeyOfRightChildOf(10).equals(20))
                fail("avl insert to right child of root does not work");

            avl2.insert(30, "30");
            Integer k = avl2.getKeyAtRoot();
            if (!k.equals(20))
                fail("avl rotate does not work");

            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child

            Assert.assertEquals(avl2.getKeyAtRoot(), new Integer(20));
            Assert.assertEquals(avl2.getKeyOfLeftChildOf(20), new Integer(10));
            Assert.assertEquals(avl2.getKeyOfRightChildOf(20), new Integer(30));

        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception AVL 000: " + e.getMessage());
        }
    }

    /**
     * Insert three values in reverse sorted order and then check the root, left,
     * and right keys to see if rebalancing occurred in the other direction.
     */
    @Test
    void testAVL_002_insert_reversed_sorted_order_simple() {
        try {
            avl.insert("C", "C");
            avl.insert("B", "B");
            avl.insert("A", "A");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    /**
     * Insert three values so that a right-left rotation is needed to fix the
     * balance.
     * <p>
     * Example: 10-30-20
     * <p>
     * Then check the root, left, and right keys to see if rebalancing occurred in
     * the other direction.
     */
    @Test
    void testAVL_003_insert_smallest_largest_middle_order_simple() {
        try {
            avl.insert("A", "A");
            avl.insert("C", "C");
            avl.insert("B", "B");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    /**
     * Insert three values so that a left-right rotation is needed to fix the
     * balance.
     * <p>
     * Example: 30-10-20
     * <p>
     * Then check the root, left, and right keys to see if rebalancing occurred in
     * the other direction.
     */
    @Test
    void testAVL_003_insert_largest_smallest_middle_order_simple() {
        try {
            avl.insert("C", "C");
            avl.insert("A", "A");
            avl.insert("B", "B");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    // My tests

    // the following two tests were used to make sure that balance factor method works

    /*
    @Test
    void testSideBalanceFactorCase1() {
        try {
            avl.insert("H", "H"); // root

            avl.insert("D", "D"); // left side of root
            avl.insert("B", "B");
            avl.insert("A", "A");
            avl.insert("C", "C");
            avl.insert("F", "F");
            avl.insert("E", "E");
            avl.insert("G", "G");

            avl.insert("L", "L"); // right side of root
            avl.insert("J", "J");
            avl.insert("I", "I");
            avl.insert("K", "K");
            avl.insert("N", "N");
            avl.insert("M", "M");
            avl.insert("O", "O");
            System.out.println(avl.nodeBalanceFactor(avl.root));
        } catch (Exception e) {
        }
        Assert.assertEquals(avl.nodeBalanceFactor(avl.root), 0);
    }

    @Test
    void testSideBalanceFactorCase2() {
        try {
            avl.insert("H", "H"); // root

            avl.insert("L", "L"); // right side of root
            avl.insert("J", "J");
            avl.insert("I", "I");
            avl.insert("K", "K");
            avl.insert("N", "N");
            avl.insert("M", "M");
            avl.insert("O", "O");
        } catch (Exception e) {
        }
        System.out.println(avl.nodeBalanceFactor(avl.root));
        Assert.assertEquals(avl.nodeBalanceFactor(avl.root), -3);
    }
    */

    @Test
    /**
     * makes sure that right left case works
     */
    void testReBalanceCase1() {
        try {
            avl.insert("A", "A");
            avl.insert("C", "C");
            avl.insert("B", "B");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that left left case works
     */
    void testReBalanceCase2() {
        try {
            avl.insert("C", "C");
            avl.insert("B", "B");
            avl.insert("A", "A");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that right right case works
     */
    void testReBalanceCase3() {
        try {
            avl.insert("A", "A");
            avl.insert("B", "B");
            avl.insert("C", "C");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that left right case works
     */
    void testReBalanceCase4() {
        try {
            avl.insert("C", "C");
            avl.insert("A", "A");
            avl.insert("B", "B");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that left left case works after remove
     */
    void testReBalanceCase5() {
        try {
            avl.insert("C", "C");
            avl.insert("D", "D");
            avl.insert("B", "B");
            avl.insert("A", "A");
            avl.remove("D");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that right right case works after remove
     */
    void testReBalanceCase6() {
        try {
            avl.insert("B", "B");
            avl.insert("A", "A");
            avl.insert("C", "C");
            avl.insert("D", "D");
            avl.remove("A");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("C", "B", "D"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that left right case works after remove
     */
    void testReBalanceCase7() {
        try {
            avl.insert("C", "C");
            avl.insert("D", "D");
            avl.insert("A", "A");
            avl.insert("B", "B");
            avl.remove("D");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * makes sure that right left case works after remove
     */
    void testReBalanceCase8() {
        try {
            avl.insert("B", "B");
            avl.insert("A", "A");
            avl.insert("D", "D");
            avl.insert("C", "C");
            avl.remove("A");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("C", "B", "D"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * tries to rebalance after a complex remove
     */
    void testReBalanceCase9() {
        try {
            avl.insert("C", "C");
            avl.insert("B", "B");
            avl.insert("E", "E");
            avl.insert("A", "A");
            avl.insert("D", "D");
            avl.insert("F", "F");
            avl.insert("G", "G");
            avl.remove("A");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("E", "C", "F", "B", "D", "G"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

    @Test
    /**
     * tries to rebalance after a complex remove
     */
    void testReBalanceCase10() {
        try {
            avl.insert("E", "E");
            avl.insert("C", "C");
            avl.insert("F", "F");
            avl.insert("B", "B");
            avl.insert("D", "D");
            avl.insert("G", "G");
            avl.insert("A", "A");
            avl.remove("G");
        } catch (Exception e) {
        }
        System.out.println(avl.getLevelOrderTraversal());
        List result = new ArrayList(Arrays.asList("C", "B", "E", "A", "D", "F"));
        assertEquals(avl.getLevelOrderTraversal(), result);
    }

}
