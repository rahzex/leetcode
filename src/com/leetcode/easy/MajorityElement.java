package com.leetcode.easy;

// https://leetcode.com/problems/majority-element/

public class MajorityElement {

    public static int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count += 1;
            else
                count -= 1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {8,7,1,8,7,7,7}));
    }
}
