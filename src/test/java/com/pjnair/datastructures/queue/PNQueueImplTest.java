package com.pjnair.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PNQueueImplTest {

    PNQueueImpl<Integer> pnQueue = null;
    Integer e1 = 1, e2 = 2, e3 = 3;

    @Before
    public void refresh() {
        pnQueue = new PNQueueImpl<>();
    }

    @Test
    public void add() throws Exception {
        pnQueue.add(e1);
        pnQueue.add(e2);
        assertEquals(e1, pnQueue.peek());
    }

    @Test
    public void poll() throws Exception {
        pnQueue.add(e1);
        pnQueue.poll();
        pnQueue.add(e2);
        assertEquals(e2, pnQueue.peek());
    }

    @Test
    public void peek() throws Exception {
        assertEquals(null, pnQueue.peek());
    }

}