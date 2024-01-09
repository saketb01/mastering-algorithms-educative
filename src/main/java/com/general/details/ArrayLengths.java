package com.general.details;

public class ArrayLengths {

    public static void main(String[] args) {

        int[] intarray = new int[]{1, 2, 3};
        System.out.println("length: " + intarray.length);
        System.out.println("middle: " + intarray[intarray.length / 2]);

        int[] anotherintarray = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("another length: " + anotherintarray.length);
        System.out.println("another middle: " + anotherintarray[anotherintarray.length / 2]);

    }

}
