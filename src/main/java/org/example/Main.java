package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 1, 4};

        bubbleSort(nums); // {1, 1, 2, 3, 4, 5}

        System.out.println(Arrays.toString(nums));
    }


    /*
    * 31 5214 compares the first two values and switches them if necessary
    * 1 35 214
    * 13 52 14
    * 132 51 4
    * 1321 54
    * 132145  it redoes the whole process again (java focuses only on the first few digits) 5 is on the side
    *
    * 13 214
    * 1 32 14
    * 12 31 4
    * 121 34
    * 12134  4 goes on the side
    *
    * 12 134
    * 1 21 34
    * 11 23 4
    * 112 34
    * 11234 does it until all the numbers are on the side
    *
    * BubbleSort contains 2 loops => nested loop*/
// this method is Big O(n^2)
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
               if (nums[j] > nums[j + 1]) {
                   int temp = nums[j];
                   nums[j] = nums[j + 1];
                   nums[j + 1] = temp;
               }
            }
        }
    }
}
