package com.algorithms.educative.twopointers;

import java.util.Objects;

public class PalindromeII {

    public static boolean isPalindrome(String s) {
        if (Objects.isNull(s) || s.isEmpty() || s.length() == 1) {
            return true;
        }
        int length = s.length();
        int startIndex = 0;
        int endIndex = length - 1;
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                //Allow shifting just one char
                return isPalindrome(s, startIndex + 1, endIndex) || isPalindrome(s, startIndex, endIndex - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String input, int left, int right) {
        while (left < right) {
            if (input.charAt(left++) != input.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        String[] inputs = {
                "DEEAD",
                "DEAD",
                "abcba",
                "abba",
                "madame",
                "dead",
                "abca",
                "tebbem",
                "eeccccbebaeeabebccceea"};

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tActual string:\t\t" + inputs[i]);
            System.out.println("\tIsPalindrome:\t" + isPalindrome(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
