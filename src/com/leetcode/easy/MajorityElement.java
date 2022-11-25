package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// // https://leetcode.com/problems/majority-element/
// https://www.youtube.com/watch?v=AoX3BPWNnoE

public class MajorityElement {

    // T O(n), S O(n)
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        Map<Integer, Integer> count = new HashMap<>();
        int majorityElement = nums[0];

        for(int num : nums) {
            if(count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
                if(count.get(majorityElement) < count.get(num)) {
                    majorityElement = num;
                }
            }
            else
                count.put(num, 1);
        }
        return majorityElement;
    }

    // T O(n), S O(1)
    public int majorityElementBetter(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            if(candidate == num) {
                count += 1;
            }
            else
                count -= 1;
        }
        return candidate;
    }
}

