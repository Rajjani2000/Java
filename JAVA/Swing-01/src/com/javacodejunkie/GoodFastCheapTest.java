package com.javacodejunkie;

import org.junit.Test;



public class GoodFastCheapTest {

    @Test
    public void testSatisfactoryGoodAndFast() {
        GoodFastCheap sut = new GoodFastCheap();
        sut.makeGood();
        sut.makeFast();
        assertTrue(sut.satisfactory());
    }

    @Test
    public void testSatisfactoryGoodAndCheap() {
        GoodFastCheap sut = new GoodFastCheap();
        sut.makeGood();
        sut.makeCheap();
        assertTrue(sut.satisfactory());
    }

    @Test
    public void testSatisfactoryFastAndCheap() {
        GoodFastCheap sut = new GoodFastCheap();
        sut.makeFast();
        sut.makeCheap();
        assertTrue(sut.satisfactory());
    }

    @Test
    public void testSatisfactoryGoodFastAndCheap() {
        GoodFastCheap sut = new GoodFastCheap();
        sut.makeGood();
        sut.makeFast();
        sut.makeCheap();
        assertTrue(sut.satisfactory());
    }
}
