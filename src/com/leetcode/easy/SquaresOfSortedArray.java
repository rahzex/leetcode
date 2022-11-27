package com.leetcode.easy;

import java.util.Stack;

public class SquaresOfSortedArray {

    // https://leetcode.com/problems/squares-of-a-sorted-array/
    // T O(n), S O(n)
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[end]) >= Math.abs(nums[start])) {
                result[i] = nums[end] * nums[end];
                end--;
            }
            else {
                result[i] = nums[start] * nums[start];
                start++;
            }
        }
        return result;
    }
}
