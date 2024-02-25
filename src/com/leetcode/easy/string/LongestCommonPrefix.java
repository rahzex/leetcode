package com.leetcode.easy.string;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // lowest length string can be the highest possible LCP
        String stringWithMinLength = getStringWithMinLength(strs);
        int possibleLCPLength = stringWithMinLength.length();

        for (int i = 0, j = 0; i < possibleLCPLength && j < strs.length; j++) {
            if (strs[j].charAt(i) != stringWithMinLength.charAt(i)) {
                possibleLCPLength = i;
            }
            // sets array to -1, so it becomes 0 after current iteration and character index to next character
            // so that it can be compared with the char at same position of all strings in the array
            if (j == strs.length - 1) {
                j = -1;
                i++;
            }
        }

        return possibleLCPLength <= 0 ? "" : stringWithMinLength.substring(0, possibleLCPLength);
    }

    private String getStringWithMinLength(String[] strs) {
        return Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .get();
    }

}
