/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class CounterTest {

    private Counter.IntegerImpl counter;

    @Before
    public void setUp() {
        this.counter = new Counter.IntegerImpl();
    }

    /**
     * Test of getTotal method, of class Counter.
     */
    @Test
    public void testGetTotal() {
    }

    /**
     * Test of clear method, of class Counter.
     */
    @Test
    public void testTotalIncrementClear() {
        assertEquals(0, (int) this.counter.getTotal());

        this.counter.increment(5);
        assertEquals((int) 5, (int) this.counter.getTotal());

        this.counter.increment(5);
        assertEquals((int) 10, (int) this.counter.getTotal());

        this.counter.clear();

        assertEquals(0, (int) this.counter.getTotal());
    }
    
}
