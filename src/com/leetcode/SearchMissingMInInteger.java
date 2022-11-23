package com.leetcode;

import java.util.Arrays;

public class SearchMissingMInInteger {

    public static int findMissingMinimumPositiveInt(int[] A) {
        Arrays.sort(A);
        int value = 1;
        int prev = 0;
        for (int i = 0; i < A.length; i++) {
            if (value == A[i])
                value++;
            else if (prev == A[i])
                continue;
            else if (value < A[i])
                return value;
            prev = A[i];
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(findMissingMinimumPositiveInt(new int[] {1,2,6,4,-1,2}));
    }

}
