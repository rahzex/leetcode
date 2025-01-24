package com.leetcode.medium;

public class RearrangeArrayElementsBySign {
    /**
     * Intuition: Since positive and negative values are arranged consecutively,
     * we can maintain separate pointers for the positive and negative values.
     * By incrementing each pointer by 2, we can efficiently move to the next index of the respective group
     * while traversing and identifying the positive and negative values.
     */
    public int[] rearrangeArray(int[] nums) {
        int posIndex = 0;
        int negIndex = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res[posIndex] = nums[i];
                posIndex += 2;
            } else {
                res[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return res;
    }
}
