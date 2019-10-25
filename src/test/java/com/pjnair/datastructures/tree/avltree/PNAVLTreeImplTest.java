package com.pjnair.datastructures.tree.avltree;

/**
 * Pranav Nair
 */

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

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
