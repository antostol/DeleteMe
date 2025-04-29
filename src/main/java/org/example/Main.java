package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 1, 4};

        InsertionSort(nums); // {1, 1, 2, 3, 4, 5}

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
    public static void bubbleSort(int[] nums, boolean ascending) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                boolean condition = ascending
                        ? nums[j] > nums[j + 1]
                        : nums[j] < nums[j + 1];
               if (condition) {
                   int temp = nums[j];
                   nums[j] = nums[j + 1];
                   nums[j + 1] = temp;
               }
            }
        }
    }

    public static void bubbleSort(int [] nums) {
        bubbleSort(nums, true);
    }

    /*
    * 315214 considers the first element as the smallest one and changes its value as it goes through the elements => starts with 3 ends with 1
    * 135214 3 ends with the second 1
    * 113524 3 ends with 2
    * 112354 3 ends with 3
    * 112354 5 ends with 4
    * 112345
    * 2 loops => nested for loop*/

    public static void SelectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
    }

    /*
    * 315214 InsertionSort starts from the second element and check in front if there is an element bigger than it
    * 3  15214
    * 1  35214 (it will overwrite it)
    * 13 5214 this iteration doesn't do anything because 3 is smaller than 5
    * 135 514 (overwrites 2)
    * 123 514
    * 1123 14
    * 11234 5
    *  */

    public static void InsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
}
