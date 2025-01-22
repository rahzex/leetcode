package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    /**
     * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
     * Output: 6
     * Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10].
     * The length of the longest subarray with a sum of 15 is 6.
     */
    public int longestSubArray(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMinusKAndIndex = new HashMap<>();
        int prefixSum = 0;
        int longestSubArrayLength = 0;
        for (int i = 0; i < arr.length; i++) {
            // calculate prefix sum till i
            prefixSum = prefixSum + arr[i];

            // if prefix sum is equals to k then longest has to be current index + 1
            // as its the highest index checked till this point
            if (prefixSum == k)
                longestSubArrayLength = i + 1;
            // check if we have seen prefixSum - k earlier, if yes then the difference between
            // current prefixSum and earlier saved prefixSum has to be k.
            // prefixSum(old) + k = prefixSum (current).
            //  OR
            // prefixSum(old) = prefixSum (current) - k.
            // thus the sum of current index prefixSum and old index prefix sum is k.
            else if (prefixSumMinusKAndIndex.containsKey(prefixSum - k)) {
                longestSubArrayLength = Math.max(i - prefixSumMinusKAndIndex.get(prefixSum - k), longestSubArrayLength);
            }

            if (!prefixSumMinusKAndIndex.containsKey(prefixSum))
                prefixSumMinusKAndIndex.put(prefixSum, i);
        }
        return longestSubArrayLength;
    }
}
