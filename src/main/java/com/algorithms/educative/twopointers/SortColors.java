package com.algorithms.educative.twopointers;

import java.util.Arrays;
import java.util.Objects;

public class SortColors {

    public static int[] sortColors(int[] colors) {
        if (Objects.isNull(colors) || colors.length == 0) {
            return colors;
        }

        /**
         * Value 0:  represents red
         * Value 1:  represents white
         * Value 2:  represents blue
         */
        int redPointer = 0; // Represents 0
        int whitePointer = 0; // Represents 1
        int bluePointer = colors.length - 1; // Represents value 2


        //{0, 1, 0})
        while (whitePointer <= bluePointer) {

            if (colors[whitePointer] == 0) {
                //Swap white and red
                int val = colors[whitePointer];
                int otherVal = colors[redPointer];

                colors[whitePointer] = otherVal;
                colors[redPointer] = val;

                //Increment both pointers
                whitePointer++;
                redPointer++;

            } else if (colors[whitePointer] == 1) {
                //white is in correct position, just move it ahead
                whitePointer++;

            } else if (colors[whitePointer] == 2) {

                //Swap white a blue
                int val = colors[whitePointer];
                int otherVal = colors[bluePointer];
                colors[whitePointer] = otherVal;
                colors[bluePointer] = val;

                //Decrement bluePointer
                bluePointer--;
            }

        }

        //System.out.println(Arrays.toString(colors));
        return colors;
    }

    public static void main(String[] args) {

        sortColors(new int[]{0, 1, 0});
        sortColors(new int[]{0});
        sortColors(new int[]{1});
        sortColors(new int[]{2});
        sortColors(new int[]{1, 1, 0, 2});
        sortColors(new int[]{2, 1, 1, 0, 0});


    }


}
