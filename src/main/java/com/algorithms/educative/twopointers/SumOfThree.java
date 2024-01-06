package com.algorithms.educative.twopointers;

import java.util.Arrays;
import java.util.Objects;

public class SumOfThree {

    public static boolean findSumOfThree(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return false;
        }
        Arrays.sort(nums);

        // 1, 2, 3, 4 target: 7 => Happy path
        // 1, 2, 3, 4 target: 8 => Happy path, move inner pointer left
        // 1, 2, 3, 10 target: 8 => Happy path, move inner pointer right
        for (int current = 0; current < nums.length; current++) {
            int currentValue = nums[current];
            int innerStart = current + 1;
            int innerEnd = nums.length - 1;
            while (innerStart < innerEnd) {
                int firstValue = nums[innerStart];
                int secondValue = nums[innerEnd];
                int currentSum = currentValue + firstValue + secondValue;
                if (currentSum == target) {
                   // System.out.println("Target: " + target + " Found triplet " + "firstValue: " + firstValue + " secondValue:  " + secondValue + " currentValue: " + currentValue);
                    return true;
                } else if (currentSum < target) {
                    innerStart++;
                } else if (currentSum > target) {
                    innerEnd--;

                }
            }

        }
        return false;
    }

    public static void main(String... args) {

        System.out.println(findSumOfThree(new int[]{1, 2, 3, 4}, 7));
        System.out.println(findSumOfThree(new int[]{1, -1, 0}, -1));
        System.out.println(findSumOfThree(new int[]{3, 7, 1, 2, 8, 4, 5}, 10));
        System.out.println(findSumOfThree(new int[]{3, 7, 1, 2, 8, 4, 5}, 21));
        System.out.println(findSumOfThree(new int[]{-1, 2, 1, -4, 5, -3}, -8));
        System.out.println(findSumOfThree(new int[]{-1, 2, 1, -4, 5, -3}, 0));


    }

}
