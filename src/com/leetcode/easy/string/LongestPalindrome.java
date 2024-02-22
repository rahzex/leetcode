package com.leetcode.easy.string;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 1)
            return 1;

        int[] characterCount = new int[128];
        int evenCharCount = 0;

        for (int i = 0; i < s.length(); i++) {
            characterCount[s.charAt(i)] += 1;
        }

        for(Integer count: characterCount) {
            if(count > 1)
                evenCharCount += (count/2) * 2;
        }

        return s.length() > evenCharCount ? evenCharCount + 1 : evenCharCount;
    }
}
