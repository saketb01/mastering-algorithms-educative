package com.algorithms.educative.twopointers;

import java.util.Objects;

public class ReverseStrings {

    public static String reverseWords(String sentence) {
        if (Objects.isNull(sentence) || sentence.length() <= 1) {
            return sentence;
        }
        // StringBuilder for efficient string manipulation:
        StringBuilder reversedString = new StringBuilder();

        // Reverse the entire string: Iterate through the original string in reverse order using a for-loop:
        for (int i = sentence.trim().length() - 1; i >= 0; i--) {
            reversedString.append(sentence.charAt(i));
        }

        //Iterate over the reversed string using two pointers
        char[] reversedStringArray = reversedString.toString().toCharArray();
        int start = 0;
        int end = 0;
        int length = reversedString.length();
        while (end <= length - 1) {
            if ((reversedStringArray[end] == ' ' || end == length - 1) && (end - start) > 2) {
                //we have a word from (start) to (end-1), so reverse it
                if (reversedStringArray[end] == ' ') {
                    reverseWord(reversedStringArray, start, end - 1);
                } else {
                    reverseWord(reversedStringArray, start, end);
                }
                end++;
                start = end;
            } else {
                end++;
            }
            /*
            for (int i = 0; i < reversedStringArray.length; i++) {
                System.out.println("counter:  " + i + " value: " + reversedStringArray[i]);
            }
            System.out.println();
            */

        }
        return String.valueOf(reversedStringArray);
    }

    private static void reverseWord(char[] inputArray, int startIndex, int endIndex) {
        //System.out.println("\t Before: " + Arrays.toString(inputArray));
        //System.out.println("\tstartIndex: " + startIndex + " start " + inputArray[startIndex]);
        //System.out.println("\tendIndex: " + endIndex + " end " + inputArray[endIndex]);
        while (startIndex <= endIndex) {
            char currentStartValue = inputArray[startIndex];
            char currentEndValue = inputArray[endIndex];
            //System.out.println("startIndex: " + startIndex + "start Value: " + currentStartValue);
            //System.out.println("endIndex: " + startIndex + "end Value: " + currentEndValue);
            inputArray[startIndex] = currentEndValue;
            inputArray[endIndex] = currentStartValue;
            startIndex++;
            endIndex--;
        }
        //System.out.println("\t    After: " + Arrays.toString(inputArray));
    }

    // Template for setting up twoPointers
    static void twoPointers(String s1) {
        int left = 0;
        int right = s1.length() - 1;
        while (left <= right) {
            left = left + 1;
            right = right - 1;
        }
    }

    public static String reverseStringWithTrimming(String text) {
        // 1. Trim leading and trailing spaces:
        String trimmedText = text.strip();

        // 2. Initialize variables for word-by-word reversal:
        if (trimmedText.isEmpty()) {
            return trimmedText; // Handle empty string case
        }
        StringBuilder reversedWords = new StringBuilder();
        String[] words = trimmedText.split(" ");

        // 3. Iterate through words in reverse order:
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.append(words[i]).append(" ");
        }

        // 4. Trim any extra space added at the end:
        return reversedWords.toString().trim();
    }


    public static void main(String... args) {


        System.out.println(reverseWords("Hello Friend"));
        System.out.println(reverseWords("We love Java "));
        System.out.println(reverseWords("To be or not to be"));
        System.out.println(reverseWords("You are amazing"));
        System.out.println(reverseWords("Hello     World"));
        System.out.println(reverseWords("Hey"));

    }

}
