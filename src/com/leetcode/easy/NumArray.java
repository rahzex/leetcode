package com.leetcode.easy;

public class NumArray {
    private int[] numArray;
    public NumArray(int[] nums) {
        numArray = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right ; i++) {
            sum += numArray[i];
        }
        return sum;
    }
}

