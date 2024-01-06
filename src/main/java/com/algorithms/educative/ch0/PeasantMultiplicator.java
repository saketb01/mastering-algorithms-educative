package com.algorithms.educative.ch0;

public class PeasantMultiplicator {
    public static int peasantMultiply(int x, int y) {
        int prod = 0;
        while (x > 0) {
            if (x % 2 == 1) {
                prod += y;
            }

            x = Math.floorDiv(x, 2);
            y += y;
        }

        return prod;
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 9;
        int prod = peasantMultiply(x, y);
        System.out.println(x + " * " + y + " = " + prod);
    }
}