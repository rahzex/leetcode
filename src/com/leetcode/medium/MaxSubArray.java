package com.leetcode.medium;

public class MaxSubArray {

    // https://leetcode.com/problems/maximum-subarray


    // Kadane's Algorithm https://www.youtube.com/watch?v=86CQq3pKSUw

    public static int maxSubArrayOptimal(int[] nums) {

        int globalMax = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int num : nums) {
            currentMax = currentMax + num;

            if (currentMax < num)
                currentMax = num;

            if (currentMax > globalMax)
                globalMax = currentMax;
        }

        return globalMax;
    }

    // Optimized by reducing repetitive computation
    // https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int windowSize = 1;
        int previousSum = 0;

        boolean isAllNeg = true;

        if (nums.length == 1)
            return nums[0];

        for (int num : nums) {
            if (num > max)
                max = num;
            if (num > 0 && isAllNeg)
                isAllNeg = false;
        }

        if (isAllNeg)
            return max;

        System.out.println("Max : " + max);

        for (int i = 0, j = windowSize; j < nums.length; i++, j++) {

            // initial computation of first two elements
            if (i == 0 && j == 1) {
                sum = nums[i] + nums[j];
            }
            else {
                // for remaining elements
                sum = sum + nums[j];
            }

            // reducing nums(i-1)th element from sum of nums(i-1,j) to get sum of nums(i,j) [i.e. sum of current window]
            if (i > 0) {
                sum = sum - nums[i-1];
            }

            // saving and updating precalculated sum of nums from i = 0 to j = n for next windowSize
            if (i == 0)
                previousSum = sum;

            if (sum > max) {
                max = sum;
            }

            System.out.println("i = " + i + ", j = " + j + ", sum = " + sum + ", max = " + max + ", windowSize = " + windowSize);

            // exit condition
            if (i == 0 && j == nums.length - 1)
                return max;

            // move to next window size after completing all possible sum of current window size
            if (j == nums.length - 1) {
                windowSize++;
                i = -1;
                j = windowSize - 1;
                sum = previousSum;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayOptimal(new int[]{-2,-1,-3,-4,-1 }));
    }
}
