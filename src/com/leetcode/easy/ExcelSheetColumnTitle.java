package com.leetcode.easy;

// https://leetcode.com/problems/excel-sheet-column-title

public class ExcelSheetColumnTitle {

    public String convertToTitle2(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0) {
            char c = (char) ('A' + (columnNumber - 1) % 26);
            sb.insert(0, c);
            columnNumber = (columnNumber - 1) / 26;
        }

        return sb.toString();
    }

    // different approach
    public String convertToTitle1(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0){
            columnNumber--;
            int curr = columnNumber % 26;
            columnNumber /= 26;
            sb.append((char)(curr+'A'));
        }

        return sb.reverse().toString();
    }

    public static String convertToTitle(int columnNumber) {
        int rem = 0;
        StringBuilder columnTitle = new StringBuilder();

        while (columnNumber > 0) {
            rem = columnNumber % 26;
            columnNumber = columnNumber / 26;

            if (rem == 0) {
                rem = 26;
                --columnNumber;
            }
            columnTitle.append((char)(rem + 64));
        }
        return columnTitle.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1352));
    }
}

/*
1352
1351 % 26
res = 51
rem = 25
50 / 26
res = 1
rem = 24

ZYB

52729 / 26
res = 2028
rem = 1
2028 / 26
res = 78
rem = 0
77 / 26
res = 1
rem = 25

AZYB
 */
