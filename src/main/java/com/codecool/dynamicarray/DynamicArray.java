package com.codecool.dynamicarray;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    private int[] array;
    private int size = 0;


    public DynamicArray(int capacity) {
        this.array = new int[capacity];

    }

    public DynamicArray() {
        this.array = new int[4];
    }

    public int getCapacity() {
        return array.length;
    }

    public int size() {
        return this.size;
    }

    public void add(int value) {
        this.array[size] = value;
        this.size++;
        int[] temp;
        if (getCapacity() >= size) {
            temp = new int[getCapacity() * 2];
            {
                if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
            }
            array = temp;
        }
    }

    public int get(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException("this is my exception for the condition");
        }
        return array[index];
    }

    public void remove(int indexToBeRemoved) {
        if(indexToBeRemoved < 0) {
            throw new ArrayIndexOutOfBoundsException("this is my exception for the condition");
        }
        if(indexToBeRemoved > size) {
            throw new ArrayIndexOutOfBoundsException("this is my exception for the condition");
        }
        List<Integer> list = new ArrayList<>();
        for(int i: array)
            list.add(i);
        list.remove(indexToBeRemoved);
        size--;
        array = list.stream().mapToInt(Integer::intValue).toArray();

    }

    public void insert(int index, int newValue) {
        int[] temp;
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException();
        if (index >= size) {
            temp = new int[(size * 2)-1];
            {
                if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
            }
            array = temp;
        }
        List<Integer> l = new ArrayList<>();
        for (int i : array)
            l.add(i);
        l.add(size < index ? size : index, newValue);
        size++;
        array = l.stream().mapToInt(i -> i).toArray();

    }


    @Override
    public String toString() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < size; i++)
            lista.add(array[i]);
        return Arrays.toString(lista.toArray());

    }
}
