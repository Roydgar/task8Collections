package ua.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ElementCounterTest {

    @Test
    public void elementCounterTest() {
        List<Integer> list = Arrays.asList(4,5,6,4,5,3,4,2,4,5,7);
        Map<Integer, Integer> expectedResult = new HashMap<>();

        expectedResult.put(2, 1);   expectedResult.put(3, 1);
        expectedResult.put(4, 4);   expectedResult.put(5, 3);
        expectedResult.put(6, 1);   expectedResult.put(7, 1);

        Assert.assertEquals(expectedResult, ElementCounter.count(list));
    }
}


