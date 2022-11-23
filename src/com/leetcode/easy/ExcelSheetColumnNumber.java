package com.leetcode.easy;

// https://leetcode.com/problems/excel-sheet-column-number/discuss/52154/Concise-java-solution-with-explanation.

public class ExcelSheetColumnNumber {

    public int titleToNumberBetter(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length() ; i++){
            int val = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + val;
        }
        return result;
    }

    // pow is calculating power of 26
    public static int titleToNumber(String columnTitle) {

        int len = columnTitle.length();
        int number = 0;
        int pow = 1;
        for (int i = len - 1; i >= 0; i--) {
            // 'A' - 1 = 64
            number += (columnTitle.charAt(i) - 64) * pow;
            pow *= 26;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AYZ"));
    }
}

/*
ZY
26 * 26 + 25 * 1
BYZA

2*26*26*26 + 25*26*26 + 26*26 + 1*1
 */
