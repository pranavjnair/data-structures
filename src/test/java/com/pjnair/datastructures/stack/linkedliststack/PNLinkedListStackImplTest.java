package com.pjnair.datastructures.stack.linkedliststack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PNLinkedListStackImplTest {
    PNLinkedListStackImpl<Integer> pnArrayStack = null;
    Integer e1 = 1, e2 = 2;

    @Before
    public void refresh() {
        pnArrayStack = new PNLinkedListStackImpl<>();
    }

    @Test
    public void push() throws Exception {
        pnArrayStack.push(e1);
        pnArrayStack.push(e2);
        assertEquals(e2, pnArrayStack.peek());
    }

    @Test
    public void pop() throws Exception {
        pnArrayStack.push(e1);
        assertEquals(e1, pnArrayStack.pop());
    }

    @Test
    public void peek() throws Exception {
        pnArrayStack.push(e1);
        assertEquals(e1, pnArrayStack.peek());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, pnArrayStack.isEmpty());
    }

    @Test
    public void search() throws Exception {
        pnArrayStack.push(e1);
        assertEquals(1, pnArrayStack.search(e1));
    }

}