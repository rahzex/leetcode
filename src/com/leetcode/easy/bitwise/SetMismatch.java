package com.leetcode.easy.bitwise;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                res[0] = nums[i];
                res[1] = nums[i] + 1;
                break;
            }
        }
        return res;
    }
}
