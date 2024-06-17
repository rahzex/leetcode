package com.leetcode.medium;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for(int num:nums) {
            switch (num) {
                case 0 : redCount++; break;
                case 1 : whiteCount++; break;
                case 2 : blueCount++;
            }
        }
        int start = 0;
        int end = redCount;
        fillArray(nums, start, end, 0);
        start = redCount;
        end = redCount + whiteCount;
        fillArray(nums, start, end, 1);
        start = start + whiteCount;
        end = end + blueCount;
        fillArray(nums, start, end, 2);
    }

    private static void fillArray(int[] nums, int start, int end, int color) {
        for (int i = start; i < end; i++) {
            nums[i] = color;
        }
    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: nums = [2,0,2,1,1,0]
        //Output: [0,0,1,1,2,2]
        //Example 2:
        //
        //Input: nums = [2,0,1]
        //Output: [0,1,2]
        int[] a1 = new int[]{0,0,2,2,2,1,0};
        sortColors(a1);
        Arrays.stream(a1).forEach(System.out::print);
    }
}
