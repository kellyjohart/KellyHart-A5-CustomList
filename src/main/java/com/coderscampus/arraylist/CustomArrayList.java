package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
    private Object[] items = new Object[10];
    private int size = 0;

    @Override
    public boolean add(T item) {
        if (size == items.length) {
            resizeArray();
        }
        items[size++] = item;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) items[index];
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + " - out of bounds");
    }

    private void resizeArray() {
        Object[] tempArray = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            tempArray[i] = items[i];
        }
        items = tempArray;
    }
}
