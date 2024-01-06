package com.algorithms.educative.twopointers;

import java.util.Arrays;
import java.util.Objects;

public class Palindrome {

    public static boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        // Replace this placeholder return statement with your code
        char[] arr = s.toCharArray();
        int length = arr.length;
        int start = 0;
        int end = length - 1;
        for (; start < end; start++, end--) {
            if (arr[start] != arr[end])
                return false;
        }
        return true;
    }

    public static boolean isPalindromeAltOne(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return true;
        }

        return s.contentEquals(new StringBuilder(s).reverse());
    }

    public static boolean isPalindromeWhileLoop(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }

    public static void main(String... args) {
        System.out.println(isPalindrome("aba"));

        String[] testCase = {
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
        };

        Arrays.stream(testCase).forEach(s -> System.out.println(s + " palindrome? " + isPalindrome(s)));

    }

}
