package com.leetcode.easy.bitwise;

// https://leetcode.com/problems/find-the-difference

public class FindDifference {

    // using addition and subtraction
    public static char findTheDifference1(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        char sum = tc[tc.length-1];

        for (int i=0; i<sc.length; i++){
            sum += tc[i];
            sum -= sc[i];
        }

        return sum;
    }

    // using bitwise XOR
    public static char findTheDifference(String s, String t) {
        int diff = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length())
                diff = diff ^ (int) s.charAt(i);
            diff = diff ^ (int) t.charAt(i);
        }

        return (char) diff;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcde"));
    }
}
