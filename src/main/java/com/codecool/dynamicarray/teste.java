package com.codecool.dynamicarray;


import java.util.*;

public class teste {
    public static int[] fct(int[] ints, int poz) {
        List<Integer> l = new ArrayList<>();
        for (int i : ints)
            l.add(i);

        l.remove(poz);
        return l.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int[] mama = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(fct(mama, 0)));

    }
}
