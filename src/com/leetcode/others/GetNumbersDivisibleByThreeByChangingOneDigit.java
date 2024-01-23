package com.leetcode.others;

public class GetNumbersDivisibleByThreeByChangingOneDigit {
    /**
     * You are given a string S, consisting of N digits, that represents a number. You can change at most one digit in the string to any other digit. How many different numbers divisible by 3 can be obtained in this way?
     * Write a function:
     * class Solution { public int solution (String S); }
     * that, given a string S of length N, returns an integer specifying how many numbers divisible by 3 can be obtained with at most one change of a digit.
     * Examples:
     * 1. Given S = "23", the function should return 7. All numbers divisible by 3 that can be obtained after at
     * most one change are: "03", "21", "24", "27", "33", "63" and "93".
     * 2. Given S = "0081", the function should return 11. All numbers divisible by 3 that can be obtained with
     * at most one change are: "0021", "0051", "0081", "0084*, "0087", "0381", "0681", "0981", "3081", "6081" and "9081".
     * 3. Given S = "022", the function should return 9. All numbers divisible by 3 that can be obtained with at
     * most one change are: "012", "021", "024", "027", "042", "072", "222", "522" and "822".
     * Write an efficient algorithm for the following assumptions:
     * • Nis an integer within the range (1-100,000);
     * • string S is made only of digits (0-9).
     */

    public int getCount(String number) {
        StringBuilder possibleMatchBuilder = new StringBuilder(number);
        int num = Integer.parseInt(number);
        char originalValueOfIndex;
        int countNumbersDivisibleByThree = 0;
        if (num%3 == 0 && num != 0)
            countNumbersDivisibleByThree++;
        for (int index = 0; index < number.length(); index++) {
            originalValueOfIndex = possibleMatchBuilder.charAt(index);
            for (int n = 48; n <= 57; n++) {
                possibleMatchBuilder.setCharAt(index, (char) n);
                int possibleMatch = Integer.parseInt(possibleMatchBuilder.toString());
                if (possibleMatch%3 == 0 && possibleMatch > 0 && possibleMatch != num)
                    countNumbersDivisibleByThree++;
            }
            possibleMatchBuilder.setCharAt(index, originalValueOfIndex);
        }
        return countNumbersDivisibleByThree;
    }
}
