package com.leetcode.medium;

import java.util.Arrays;

public class ProductOfAnArrayExceptSelf {
    public int[] productExceptSelfBetter(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] product = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for (int i = 0; i < nums.length; i++) {
            product[i] = prefix[i] * suffix[i];
        }

        return product;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] fp = new int[nums.length];
        int[] bp = new int[nums.length];
        int[] result = new int[nums.length];

        fp[0] = nums[0];
        bp[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1, j = nums.length - 2; i < nums.length - 1 && j >= 0; i++, j--) {
            fp[i] = fp[i-1] * nums[i];
            bp[j] = bp[j+1] * nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                result[i] = bp[i+1];
            else if (i == nums.length - 1)
                result[i] = fp[i-1];
            else
                result[i] = fp[i-1] * bp[i+1];
        }
        return result;
    }

    public int[] productExceptSelfInPlace(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length);

        for (int i = 1, j = nums.length - 2; i < nums.length - 1 && j >= 0; i++, j--) {
            nums[i] = nums[i-1] * nums[i];
            result[j] = result[j+1] * result[j];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                result[i] = result[i+1];
            else if (i == nums.length - 1)
                result[i] = nums[i-1];
            else
                result[i] = nums[i-1] * result[i+1];
        }
        return result;
    }
}
