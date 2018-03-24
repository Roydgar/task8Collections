package ua.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArrayCollectionTest {


    @Test
    public void testConstructor() {
        List<Integer> array = new ArrayCollection<>();
        Assert.assertEquals(array.size(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructorParam() {
        List<Integer> array = new ArrayCollection<>(-1);
    }

    @Test
    public void testElementAddition() {
        List<Integer> array = new ArrayCollection<>();
        for (int i = 0; i < 200; i++) {
            array.add(i);
        }
        Assert.assertEquals(array.size(), 200);
    }

    @Test
    public void testElementGetting() {
        List<Integer> array = new ArrayCollection<>();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        Assert.assertEquals(array.get(5), new Integer(5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIndexOutOfRange() {
        List<Integer> array = new ArrayCollection<>();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        array.get(15);
    }
}
