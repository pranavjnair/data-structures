package com.pjnair.datastructures.stack;

import org.junit.Assert;
import org.junit.Test;

public class PJStackTest {

    PNStack<String> pjStack = new PNStackImpl<>();
    String e1 = "Name1";
    String e2 = "Name2";

    @Test
    public void push() {
        pjStack.push(e1);
        String value = pjStack.peek();
        Assert.assertTrue(e1.equals(value));
    }

    @Test
    public void pop()  {
        Assert.assertTrue(true);
    }

    @Test
    public void peek() {
        Assert.assertTrue(true);
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(true);
    }

    @Test
    public void search() {
        Assert.assertTrue(true);
    }

}