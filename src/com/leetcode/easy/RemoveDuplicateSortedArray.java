package com.leetcode.easy;

public class RemoveDuplicateSortedArray {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array

    public static int removeDuplicates(int[] nums) {
        if (null == nums)
            return 0;
        else if (nums.length <= 1)
            return nums.length;

        int uniqueIndex = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[uniqueIndex] = nums[i+1];
                uniqueIndex++;
            }
        }

        return uniqueIndex;
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{ 0,1,1 }));
    }

}
