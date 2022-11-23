package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        boolean isContainsDouble = false;

        for (int num : nums) {
            if (numbers.contains(num)) {
                isContainsDouble = true;
                break;
            }
            else
                numbers.add(num);
        }

        return isContainsDouble;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,3,4,3,2,4,2}));
    }
}
