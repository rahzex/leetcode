package com.leetcode.medium;

public class MaxScorefromSubarrayMin {
    // Intuition: min 2 values of any sub array will be among any of the consecutive pair of numbers in the array.
    // So we can check which pair has the highest sum in the whole array.
    public int pairWithMaxSum(int arr[]) {
        int maxSum = 0;
        int currSum = 0;
        for (int i = 1; i < arr.length; i++) {
            currSum = arr[i-1] + arr[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
