package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedNumbers {

    /**
     Time Complexity : O(n)
     Space Complexity : O(1) -> Not using additional space to keep track
     **/
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int indexToBeModified = Math.abs(nums[i]) - 1;
            if (nums[indexToBeModified] > 0)
                nums[indexToBeModified] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missingNumbers.add(i+1);
        }

        return missingNumbers;
    }

    /**
     Time Complexity : O(n)
     Space Complexity : O(n)
     **/
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        boolean[] trackedNumbers = new boolean[n+1];
        List<Integer> missingNumbers = new ArrayList<>();

        for (int index : nums) {
            trackedNumbers[index] = true;
        }

        for (int i = 1; i < trackedNumbers.length; i++) {
            if (!trackedNumbers[i]) {
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{1,1,5,3,5,6}).forEach(System.out::println);
    }
}
