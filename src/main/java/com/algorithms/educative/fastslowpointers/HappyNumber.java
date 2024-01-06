package com.algorithms.educative.fastslowpointers;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        Map<Integer, Integer> squaresMap = new HashMap<>(); //Not needed - unnecessary extra space
        int slow = n;
        int fast = sumSquaredDigits(slow);
        squaresMap.put(slow, fast);

        while (fast != 1 && fast != slow && !squaresMap.containsKey(fast)) {
            //System.out.println("fast: " + fast + " slow: " + slow);
            slow = fast;
            fast = sumSquaredDigits(fast);
            squaresMap.put(slow, fast);
        }

        System.out.println(squaresMap);
       // System.out.println("fast: " + fast + " slow: " + slow);
        return fast == 1;
    }

    private static int sumSquaredDigits(int number) {
        int sum = 0;
        //28
        while (number >= 10) {
            int remainder = number % 10;
            sum += remainder * remainder;
            number /= 10;
        }


        sum += number * number; //default condition: single-digit number

        return sum;
    }

    public static void main(String[] args) {
        int[] inputs = {
                4,
                68,
                100,
                2147483646,
                1,
                19,
                8,
                7,
                28
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput Number:\t\t" + inputs[i]);
            //System.out.println("\tsumSquaredDigits:\t" + sumSquaredDigits(inputs[i]));
            System.out.println("\tIsHappyNumber:\t" + isHappyNumber(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


    }

}
