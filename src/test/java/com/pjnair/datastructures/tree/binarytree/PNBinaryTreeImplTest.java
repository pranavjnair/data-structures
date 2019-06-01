package com.pjnair.datastructures.tree.binarytree;

/**
 * Pranav Nair
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class PNBinaryTreeImplTest {

    PNBinaryTreeImpl<String, String> bst;
    PNBinaryTreeImpl<Integer, String> bst2;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void refresh() throws Exception {
        // The setup must initialize this class's instances
        // and the super class instances.
        // Because of the inheritance between the interfaces and classes,
        // we can do this by calling createInstance() and casting to the desired type
        // and assigning that same object reference to the super-class fields.
        bst = new PNBinaryTreeImpl<>();
        bst2 = new PNBinaryTreeImpl<>();
        bst.numKeys = 0;
        bst2.numKeys = 0;
    }

    // My tests

    @Test
    /**
     * pre order traversal of a balanced tree
     */
    void testPreOrderTraversalCase1() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");
            bst.insert("G", "G");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("I", "I");
            bst.insert("K", "K");
            bst.insert("N", "N");
            bst.insert("M", "M");
            bst.insert("O", "O");
            System.out.println(bst.getPreOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("H", "D", "B", "A", "C", "F", "E", "G", "L", "J", "I", "K", "N", "M", "O"));
        assertEquals(bst.getPreOrderTraversal(), list);
    }

    @Test
    /**
     * pre order traversal of an unbalanced tree
     */
    void testPreOrderTraversalCase2() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("N", "N");
            bst.insert("M", "M");
            System.out.println(bst.getPreOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("H", "D", "A", "C", "F", "E", "L", "J", "N", "M"));
        assertEquals(bst.getPreOrderTraversal(), list);
    }

    @Test
    /**
     * post order traversal of a balanced tree
     */
    void testPostOrderTraversalCase1() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");
            bst.insert("G", "G");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("I", "I");
            bst.insert("K", "K");
            bst.insert("N", "N");
            bst.insert("M", "M");
            bst.insert("O", "O");
            System.out.println(bst.getPostOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("A", "C", "B", "E", "G", "F", "D", "I", "K", "J", "M", "O", "N", "L", "H"));
        assertEquals(bst.getPostOrderTraversal(), list);
    }

    @Test
    /**
     * post order traversal of an unbalanced tree
     */
    void testPostOrderTraversalCase2() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("N", "N");
            bst.insert("M", "M");
            System.out.println(bst.getPostOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("C", "A", "E", "F", "D", "J", "M", "N", "L", "H"));
        assertEquals(bst.getPostOrderTraversal(), list);
    }

    @Test
    /**
     * Tests height of the BST
     */
    void testGetHeight() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");
            bst.insert("G", "G");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("I", "I");
            bst.insert("K", "K");
            bst.insert("N", "N");
            bst.insert("M", "M");
            bst.insert("O", "O");
        } catch (Exception e) {
        }
        assertTrue(4 == bst.getHeight());
    }

    @Test
    /**
     * level order traversal of a balanced tree
     */
    void testLevelOrderTraversalCase1() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");
            bst.insert("G", "G");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("I", "I");
            bst.insert("K", "K");
            bst.insert("N", "N");
            bst.insert("M", "M");

        } catch (Exception e) {
        }
        System.out.println(bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * level order traversal of an unbalanced tree
     */
    void testLevelOrderTraversalCase2() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("N", "N");
            bst.insert("M", "M");

            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("H", "D", "L", "A", "F", "J", "N", "C", "E", "M"));
        assertEquals(list, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * in order traversal of a balanced tree
     */
    void testInOrderTraversalCase1() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");
            bst.insert("G", "G");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("I", "I");
            bst.insert("K", "K");
            bst.insert("N", "N");
            bst.insert("M", "M");
            bst.insert("O", "O");
            System.out.println(bst.getInOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"));
        assertEquals(bst.getInOrderTraversal(), list);
    }

    @Test
    /**
     * in order traversal of an unbalanced tree
     */
    void testInOrderTraversalCase2() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("N", "N");
            bst.insert("M", "M");
            System.out.println(bst.getInOrderTraversal());
        } catch (Exception e) {
        }
        List list = new ArrayList(Arrays.asList("A", "C", "D", "E", "F", "H", "J", "L", "M", "N"));
        assertEquals(bst.getInOrderTraversal(), list);
    }

    @Test
    /**
     * inserts,removes,inserts same node
     */
    void testInsertRemoveInsert() {
        try {
            bst.insert("A", "A");
            System.out.println(bst.getLevelOrderTraversal());
            bst.remove("A");
            System.out.println(bst.getLevelOrderTraversal());
            bst.insert("A", "A");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        assertTrue(1 == bst.numKeys());
    }

    @Test
    /**
     * inserts three nodes so root has both children
     */
    void testInsertCase1() {
        try {
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("B", "A", "C"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * inserts a duplicate node
     */
    void testInsertCase2() {
        try {
            bst.insert("A", "A");
            bst.insert("A", "A");
            System.out.println(bst.numKeys);
            Assert.assertEquals(bst.numKeys,1);
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * inserts a null node
     */
    void testInsertCase3() {
        try {
            assertThrows(NullPointerException.class, () -> {
                bst.insert(null, null);
            });
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * inserts and then removes same node
     */
    void testRemoveCase1() {
        try {
            bst.insert("A", "A");
            bst.remove("A");
        } catch (Exception e) {
        }
        List result = new ArrayList();
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * makes sure that when deleting node, right node replaces it
     */
    void testRemoveCase2() {
        try {
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.remove("A");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("B", "C"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * deletion of right node that exists
     */
    void testRemoveCase3() {
        try {
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.remove("C");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("B", "A"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * makes sure that when A is deleted B replaces it
     */
    void testRemoveCase4() {
        try {
            bst.insert("A", "A");
            bst.insert("B", "B");
            bst.remove("A");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("B"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * makes sure that when B is deleted A replaces it
     */
    void testRemoveCase5() {
        try {
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.remove("B");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("A"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * deletes node and makes sure the right node in left subtree replaces it
     */
    void testRemoveCase6() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("D", "D"); // left side of root
            bst.insert("B", "B");
            bst.insert("A", "A");
            bst.insert("C", "C");
            bst.insert("F", "F");
            bst.insert("E", "E");
            bst.insert("G", "G");

            bst.remove("H");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("D", "B", "F", "A", "C", "E", "G"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * deletes node and makes sure the right node in right subtree replaces it
     */
    void testRemoveCase7() {
        try {
            bst.insert("H", "H"); // root

            bst.insert("L", "L"); // right side of root
            bst.insert("J", "J");
            bst.insert("I", "I");
            bst.insert("K", "K");
            bst.insert("N", "N");
            bst.insert("M", "M");
            bst.insert("O", "O");

            bst.remove("H");
            System.out.println(bst.getLevelOrderTraversal());
        } catch (Exception e) {
        }
        List result = new ArrayList(Arrays.asList("L", "J", "N", "I", "K", "M", "O"));
        assertEquals(result, bst.getLevelOrderTraversal());
    }

    @Test
    /**
     * try to remove a null node
     */
    void testRemoveCase8() {
        try {
            assertThrows(NullPointerException.class, () -> {
                bst.remove(null);
            });
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * try to remove a non existent node
     */
    void testRemoveCase9() {
        try {
            Assert.assertEquals(bst.remove("A"), false);
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * try to remove a non existent node
     */
    void testRemoveCase10() {
        try {
            bst.insert("A", "A");
            Assert.assertEquals(bst.remove("B"), false);

        } catch (Exception e) {
        }
    }

    @Test
    /**
     * try to get a null node
     */
    void testGetCase1() {
        try {
            assertThrows(NullPointerException.class, () -> {
                bst.get(null);
            });
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * try to get a non existent node
     */
    void testGetCase2() {
        try {
            Assert.assertEquals(bst.get("A"), null);
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * try to get a non existent node
     */
    void testGetCase3() {
        try {
            bst.insert("A", "A");
            Assert.assertEquals(bst.get("B"),null);
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * makes sure right value is get
     */
    void testGetCase4() {
        try {
            bst.insert("B", "b");
            bst.insert("A", "a");
            bst.insert("C", "c");
            Assert.assertEquals("a", bst.get("A"));
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * tries to call contain with a null node
     */
    void testContainsCase1() {
        try {
            bst.insert("B", "b");
            bst.insert("A", "a");
            bst.insert("C", "c");
            assertThrows(NullPointerException.class, () -> {
                bst.contains(null);
            });
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * tries to call contain on a non existent node
     */
    void testContainsCase2() {
        try {
            bst.insert("C", "c");
            bst.insert("B", "b");
            bst.insert("D", "d");
            assertTrue(false == bst.contains("A"));
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * tries to call contain on a non existent node
     */
    void testContainsCase3() {
        try {
            bst.insert("C", "c");
            bst.insert("B", "b");
            bst.insert("D", "d");
            assertTrue(false == bst.contains("E"));
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * gets a height of an empty tree
     */
    void testGetHeightCase1() {
        assertTrue(bst.getHeight() == 0);
    }

    @Test
    /**
     * gets a height of a root with both its children
     */
    void testGetHeightCase2() {
        try {
            bst.insert("C", "C");
            bst.insert("B", "B");
            bst.insert("D", "D");
        } catch (Exception e) {
        }
        assertTrue(bst.getHeight() == 2);
    }
}