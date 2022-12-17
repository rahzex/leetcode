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
}
