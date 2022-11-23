package com.leetcode.easy;

public class LengthOfLastWord {

    // https://leetcode.com/problems/length-of-last-word

    public static int lengthOfLastWord(String s) {

        int len = s.length();
        int length = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && length > 0) {
                return length;
            }
            else if (s.charAt(i) != ' ') {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" g "));
    }
}
