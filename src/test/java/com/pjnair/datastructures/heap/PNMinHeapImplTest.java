package com.pjnair.datastructures.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PNMinHeapImplTest {

    PNMinHeapImpl<Integer> pnMinHeap;
    Integer e1 = 10, e2 = 20, e3 = 30, e4 = 40, e5 = 50;

    @Before
    public void refresh() {
        pnMinHeap = new PNMinHeapImpl<Integer>();
    }

    @Test
    public void enqueue1() throws Exception {
        pnMinHeap.enqueue(e3);
        pnMinHeap.enqueue(e1);
        pnMinHeap.enqueue(e2);
        assertEquals(e1, pnMinHeap.peek());
    }

    @Test
    public void enqueue2() throws Exception {
        pnMinHeap.enqueue(e3);
        pnMinHeap.enqueue(e2);
        pnMinHeap.enqueue(e1);
        assertEquals(e1, pnMinHeap.peek());
    }

    @Test
    public void dequeue() throws Exception {
        pnMinHeap.enqueue(e3);
        pnMinHeap.enqueue(e1);
        pnMinHeap.enqueue(e2);
        pnMinHeap.dequeue();
        assertEquals(e2, pnMinHeap.peek());
    }

    @Test
    public void peek() throws Exception {
        pnMinHeap.enqueue(e1);
        assertEquals(e1, pnMinHeap.peek());
    }

    @Test
    public void size() throws Exception {
        pnMinHeap.enqueue(e1);
        assertEquals(1, pnMinHeap.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, pnMinHeap.isEmpty());
    }

}