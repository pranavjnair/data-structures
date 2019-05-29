package com.pjnair.datastructures.binarytree;

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

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
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

    /**
     * Test that empty trees still produce a valid but empty traversal list
     * for each of the four traversal orders.
     */
    @Test
    void testBST_001_empty_traversal_orders() {
        try {

            List<String> expectedOrder = new ArrayList<String>();

            // Get the actual traversal order lists for each type
            List<String> inOrder = bst.getInOrderTraversal();
            List<String> preOrder = bst.getPreOrderTraversal();
            List<String> postOrder = bst.getPostOrderTraversal();
            List<String> levelOrder = bst.getLevelOrderTraversal();

            // UNCOMMENT IF DEBUGGING THIS TEST
            System.out.println("   EXPECTED: " + expectedOrder);
            System.out.println("   In Order: " + inOrder);
            System.out.println("  Pre Order: " + preOrder);
            System.out.println(" Post Order: " + postOrder);
            System.out.println("Level Order: " + levelOrder);

            assertEquals(expectedOrder, inOrder);
            assertEquals(expectedOrder, preOrder);
            assertEquals(expectedOrder, postOrder);
            assertEquals(expectedOrder, levelOrder);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception 002: " + e.getMessage());
        }

    }

    /**
     * Test that trees with one key,value pair produce a valid traversal lists
     * for each of the four traversal orders.
     */
    @Test
    void testBST_002_check_traversals_after_insert_one() {

        try {

            List<Integer> expectedOrder = new ArrayList<Integer>();
            expectedOrder.add(10);
            bst2.insert(10, "ten");
            if (bst2.numKeys() != 1)
                fail("added 10, size should be 1, but was " + bst2.numKeys());

            List<Integer> inOrder = bst2.getInOrderTraversal();
            List<Integer> preOrder = bst2.getPreOrderTraversal();
            List<Integer> postOrder = bst2.getPostOrderTraversal();
            List<Integer> levelOrder = bst2.getLevelOrderTraversal();

            // UNCOMMENT IF DEBUGGING THIS TEST
            System.out.println("   EXPECTED: " + expectedOrder);
            System.out.println("   In Order: " + inOrder);
            System.out.println("  Pre Order: " + preOrder);
            System.out.println(" Post Order: " + postOrder);
            System.out.println("Level Order: " + levelOrder);

            assertEquals(expectedOrder, inOrder);
            assertEquals(expectedOrder, preOrder);
            assertEquals(expectedOrder, postOrder);
            assertEquals(expectedOrder, levelOrder);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception 003: " + e.getMessage());
        }

    }


    /**
     * Test that the in-order traversal order is correct if the
     * items are entered in a way that creates a balanced BST
     * <p>
     * Insert order: 20-10-30
     * In-Order traversal order: 10-20-30
     */
    @Test
    void testBST_003_check_inOrder_for_balanced_insert_order() {
        // insert 20-10-30 BALANCED
        try {
            bst2.insert(20, "1st key inserted");
            bst2.insert(10, "2nd key inserted");
            bst2.insert(30, "3rd key inserted");

            // expected inOrder 10 20 30
            List<Integer> expectedOrder = new ArrayList<Integer>();
            expectedOrder.add(10);   // L
            expectedOrder.add(20);   // V
            expectedOrder.add(30);   // R

            // GET IN-ORDER and check
            List<Integer> actualOrder = bst2.getInOrderTraversal();
            assertEquals(expectedOrder, actualOrder);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception 004: " + e.getMessage());
        }
    }

    /**
     * Test that the pre-order traversal order is correct if the
     * items are entered in a way that creates a balanced BST
     * <p>
     * Insert order: 20-10-30
     * Pre-Order traversal order: 20-10-30
     */
    @Test
    void testBST_004_check_preOrder_for_balanced_insert_order() {
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

    /**
     * Test that the post-order traversal order is correct if the
     * items are entered in a way that creates a balanced BST
     * <p>
     * Insert order: 20-10-30
     * Post-Order traversal order: 10-30-20
     */
    @Test
    void testBST_005_check_postOrder_for_balanced_insert_order() {
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

    /**
     * Test that the level-order traversal order is correct if the
     * items are entered in a way that creates a balanced BST
     * <p>
     * Insert order: 20-10-30
     * Level-Order traversal order: 20-10-30
     */
    @Test
    void testBST_006_check_levelOrder_for_balanced_insert_order() {
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

    /**
     * Test that the in-order traversal order is correct if the
     * items are entered in a way that creates an un-balanced BST
     * <p>
     * Insert order: 10-20-30
     * In-Order traversal order: 10-20-30
     */
    @Test
    void testBST_007_check_inOrder_for_not_balanced_insert_order() {
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

    /**
     * Test that the pre-order traversal order is correct if the
     * items are entered in a way that creates an un-balanced BST
     * <p>
     * Insert order: 10-20-30
     * Pre-Order traversal order: 10-20-30
     */
    @Test
    void testBST_008_check_preOrder_for_not_balanced_insert_order() {
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

    /**
     * Test that the post-order traversal order is correct if the
     * items are entered in a way that creates an un-balanced BST
     * <p>
     * Insert order: 10-20-30
     * Post-Order traversal order: 30-20-10
     */
    @Test
    void testBST_009_check_postOrder_for_not_balanced_insert_order() {
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

    /**
     * Test that the level-order traversal order is correct if the
     * items are entered in a way that creates an un-balanced BST
     * <p>
     * Insert order: 10-20-30
     * Level-Order traversal order: 30-20-10
     */
    @Test
    void testBST_010_check_levelOrder_for_not_balanced_insert_order() {
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
            assertThrows(DuplicateKeyException.class, () -> {
                bst.insert("A", "A");
            });
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * inserts a null node
     */
    void testInsertCase3() {
        try {
            assertThrows(IllegalNullKeyException.class, () -> {
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
            assertThrows(IllegalNullKeyException.class, () -> {
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
            assertThrows(KeyNotFoundException.class, () -> {
                bst.remove("A");
            });
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
            assertThrows(KeyNotFoundException.class, () -> {
                bst.remove("B");
            });
        } catch (Exception e) {
        }
    }

    @Test
    /**
     * try to get a null node
     */
    void testGetCase1() {
        try {
            assertThrows(IllegalNullKeyException.class, () -> {
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
            assertThrows(KeyNotFoundException.class, () -> {
                bst.get("A");
            });
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
            assertThrows(KeyNotFoundException.class, () -> {
                bst.get("B");
            });
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
            assertThrows(IllegalNullKeyException.class, () -> {
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