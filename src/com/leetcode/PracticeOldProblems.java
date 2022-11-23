package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.leetcode.collections.ListNode;

public class PracticeOldProblems {

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int[] result = new int[1];

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (numbers.containsKey(val)) {
                result[0] = numbers.get(val);
                result[1] = i;
                break;
            }
            else
                numbers.put(nums[i], i);
        }
        return result;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int jewelCount = 0;
        Set<Character> j = new HashSet<>();

        for (char jewel : jewels.toCharArray()) {
            j.add(jewel);
        }

        for (char stone : stones.toCharArray()) {
            if (j.contains(stone))
                jewelCount++;
        }
        return jewelCount;
    }

}
