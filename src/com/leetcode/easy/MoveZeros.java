package com.leetcode.easy;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int correctPointer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[correctPointer] = nums[i];
                correctPointer += 1;
            }
        }

        for(; correctPointer < nums.length; correctPointer++) {
            nums[correctPointer] = 0;
        }
    }

    public void moveZeroesIntuitive(int[] arr) {
        for (int i = 0, j = 1; j < arr.length;) {
            // go to next index if i is non-zero
            if (arr[i] != 0) {
                i++; j++;
            }
            else {
                // if j is non-zero then swap with j and move to next positions
                if (arr[j] != 0) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                    i++; j++;
                }
                else
                    j++; // if j is zero then move to next
            }
        }
    }
}
