package com.cevher.java.generic;


import java.util.Arrays;


public class CustomNonGenericList {

    public static void main(String[] args) {
        CustomList lst = new CustomList();
        lst.add("first");
        lst.add("Second");
        lst.add("Third");
        System.out.println(lst);

        for (int i = 0; i < lst.size(); ++i) {
            String str = (String) (lst.get(i));
            System.out.println(str);
        }
        try {
            lst.add(1);
            String str = (String) (lst.get(3));
            System.out.println(str);
        } catch (ClassCastException cce) {
            // runtime error
            cce.printStackTrace();
        }
    }
}

/**
 * Non-Type-Safe Non-Generic MyArrayList
 */
class CustomList {
    private int size;
    private Object[] elements;

    public CustomList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    public void add(Object newElement) {
        if (size >= elements.length) {
            Object[] tempElements = new Object[size + 10];
            for (int i = 0; i < size; i++) {
                tempElements[i] = elements[i];
            }
            elements = tempElements;
        }
        elements[size] = newElement;
        ++size;
    }

    public void clear() {
        elements = new Object[10];
    }

    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index:%s Size:%s", index, size));
        }
        return elements[index];
    }

    private int getSize() {
        return size;
    }

    public int size() {
        return getSize();
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
    }
}