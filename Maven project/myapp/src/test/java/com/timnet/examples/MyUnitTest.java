package com.timnet.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andrei.Apostol on 7/10/2017.
 */
public class MyUnitTest {

    @Test
    public void testConcatenate(){
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");
        assertEquals("onetwo", result);
    }

    @Test
    public void testConcatNulls(){
        MyUnit unit = new MyUnit();
        String result = unit.concatenate("one", null);
        assertNotNull(result);
        assertEquals("one", result);
    }

    @Test
    public void testGetBoolean(){
        MyUnit myUnit = new MyUnit();
        assertTrue(myUnit.getBoolean());
    }
}
