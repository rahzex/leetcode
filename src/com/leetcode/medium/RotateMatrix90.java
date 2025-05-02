package com.leetcode.medium;

public class RotateMatrix90 {
    /**
     *     matrix -> transpose -> swap first & last column
     *     1 2 3     1 4 7     7 4 1
     *     4 5 6 --> 2 5 8 --> 8 5 2
     *     7 8 9     3 6 9     9 6 3
     *     --------------------------
     *     TC: O(n * n)
     *     SC: O(1)
    */
    public void rotate(int[][] matrix) {
        //transpose
        for(int commonPos = 0; commonPos < matrix.length; commonPos++) {
            for(int i = commonPos; i < matrix.length; i++) {
                // skipping same position swap
                if(commonPos != i) {
                    int temp = matrix[i][commonPos];
                    matrix[i][commonPos] = matrix[commonPos][i];
                    matrix[commonPos][i] = temp;
                }
            }
        }

        //swap
        for(int fc = 0, lc = matrix.length - 1; fc < lc; fc++, lc--) {
            for(int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][fc];
                matrix[i][fc] = matrix[i][lc];
                matrix[i][lc] = temp;
            }
        }
    }
}
