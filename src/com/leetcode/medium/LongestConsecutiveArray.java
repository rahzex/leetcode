package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveArray {

    /**
     * Intuition : to find any sequence, we should first find the lowest element/starting number
     * of that sequence in the array.
     * Thus, we check if current number's (n) previous number (n - 1) is present in the set or not.
     * This ensures that if current number can be considered as a first element of a sequence or not.
     * If n - 1 is not present then we increment that number by 1 and keep checking till we find end of that sequence
     * while counting the length of the current sequence.
     */

    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int maxSeqLength = 0;
        int currSeqLength;

        for (int num : nums) {
            numbers.add(num);
        }

        for (int number : numbers) {
            if (!numbers.contains(number - 1)) {
                currSeqLength = 0;
                int currSeqNum = number;
                // if next number in sequence in array then increase currSeqLen value until it ends
                while (numbers.contains(currSeqNum)) {
                    currSeqLength++;
                    currSeqNum++;
                }

                if (currSeqNum > maxSeqLength)
                    maxSeqLength = currSeqLength;
            }
        }
        return maxSeqLength;
    }
}
