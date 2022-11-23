package com.leetcode.easy;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/

public class MissingNumber {

    /**
     Time Complexity : O(n)
     Space Complexity : O(1)

     NOTE : XOR approach will fail in case of duplicate elements.
     **/
    public static int missingNumberBest(int[] num) {
        int xoredValue = num.length;
        for (int i = 0; i < num.length; i++) {
            xoredValue ^= i ^ num[i];
        }

        return xoredValue;
    }

    /**
     Time Complexity : O(n)
     Space Complexity : O(1)
     NOTE : SUM approach might fail in case of overflow or if duplicate are present.
     **/
    public static int missingNumberBetter(int[] nums) {
        int expectedSum = nums.length;
        int originalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            expectedSum += i;
            originalSum += nums[i];
        }

        // or we can have        -> int missingNumber = num.length;
        // then inside the loop  -> missingNumber = missingNumber + i - num[i];
        // i.e same as           -> missingNumber += i - num[i];

        return expectedSum - originalSum;
    }

    /**
     Time Complexity : O(n)
     Space Complexity : O(n)
     NOTE : This approach will pass for duplicate elements as well as if multiple numbers are missing.
     **/
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int[] trackedNumbers = new int[n+1];
        int missingNum = 0;
        Arrays.fill(trackedNumbers, 0);

        for (int index : nums) {
            trackedNumbers[index] = 1;
        }

        for (int i = 1; i < trackedNumbers.length; i++) {
            if (trackedNumbers[i] != 1) {
                missingNum = i;
                break;
            }
        }

        // to find all missing number
        // int[] res = Arrays.stream(trackedNumbers).filter(num -> num != 1).toArray();

        return missingNum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumberBest(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
