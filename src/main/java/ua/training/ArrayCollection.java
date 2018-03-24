package ua.training;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class ArrayCollection<T> extends AbstractList<T> implements List<T>,
        RandomAccess, Cloneable, Serializable {

    private static final long serialVersionUID = -2037734006743087939L;

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private transient Object[] array;

    public ArrayCollection() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayCollection(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Illegal size: " + size);
        array = new Object[size];
    }

    private void ensureCapacity() {
        if (size + 1 >= array.length){
            int arrLength = array.length;
            array = Arrays.copyOf(array, arrLength + (arrLength >> 1));
        }
    }
    private void checkRange(int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("Index: " + index + "; size: " + size);
    }
    @Override
    public boolean add(T element) {
        ensureCapacity();
        array[size++] = element;
        return true;
    }
    @Override
    public T get(int index) {
        checkRange(index);
        return (T)array[index];
    }

    @Override
    public int size() {
        return size;
    }

    public Object[] toArray() {
        return array;
    }

    @Override
    protected Object clone(){
        try {
            ArrayCollection arrCollection = (ArrayCollection<?>)super.clone();
            arrCollection.array = Arrays.copyOf(array, size);
            return arrCollection;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
