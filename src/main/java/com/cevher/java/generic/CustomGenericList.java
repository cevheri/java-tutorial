package com.cevher.java.generic;

import java.util.Arrays;

public class CustomGenericList {

    public static void main(String[] args) {
        GenericList<String> strings = new GenericList<>();
        strings.add("first Gen Val");
        strings.add("Second Gen Val");
        strings.add("Third Gen Val");
        System.out.println(strings); // [first Gen Val, Second Gen Val, Third Gen Val]
        // gen.add(1); compile time error :)
        for (int i = 0; i < strings.size(); ++i) {
            String str = strings.get(i);
            System.out.println("String value: "+str);
        }

        GenericList<Integer> integers = new GenericList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers); // [1, 2, 3]
        for (int i = 0; i < integers.size(); i++) {
            int num = integers.get(i);
            System.out.println("Integer value:" + num);
        }

    }
}

/**
 * Generics Classes with Parameterized Types GenericList
 */
class GenericList<E> {
    private int size;
    private E[] elements;

    public GenericList() {
        this.elements = (E[]) new Object[10];
        this.size = 0;
    }

    public void add(E newGenElement) {
        if (size >= elements.length) {
            E[] tempElements = (E[]) new Object[size + 10];
            for (int i = 0; i < size; i++) {
                tempElements[i] = elements[i];
            }
            elements = tempElements;
        }
        elements[size] = newGenElement;
        ++size;
    }

    public void clear() {
        elements = (E[]) new Object[10];
    }

    public E get(int index) {
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
