package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascaleTriangle = new ArrayList<>();
        List<Integer> currentRow;
        List<Integer> previousRow = null;
        for (int i = 0; i < numRows; i++) {
            currentRow = new ArrayList<>();
            if (i > 1) previousRow = pascaleTriangle.get(i-1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    currentRow.add(1);
                else {
                    if (j < previousRow.size())
                        currentRow.add(previousRow.get(j-1) + previousRow.get(j));
                }
            }
            System.out.println("\nSize : " + currentRow.size());
            currentRow.forEach(System.out::print);
            pascaleTriangle.add(currentRow);
        }
        return pascaleTriangle;
    }

    public static void main(String[] args) {
        generate(0);
    }
}

/*
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */

