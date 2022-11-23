package com.leetcode.easy;

public class IndexOf {

    // https://leetcode.com/problems/implement-strstr

    public int strStr(String haystack, String needle) {
        // Brute force approach
        if (null == haystack || haystack.length() < 1)
            return 0;
        if (haystack.length() < needle.length())
            return -1;

        int len = needle.length();
        int countLength = 1;

        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                countLength = 0;
                for (int j = i, subStringIndex = 0; j < len+i; j++, subStringIndex++) {
                    if (haystack.charAt(j) != needle.charAt(subStringIndex))
                        break;
                    else {
                        countLength++;
                        if (countLength == len)
                            return i;
                    }
                }
            }
        }
        return -1;
    }

    // https://www.youtube.com/watch?v=4jY57Ehc14Y

    public String strStrKMP(String haystack, String needle) {
        //KMP algorithms
        if(needle.equals(""))
            return haystack;
        if(haystack.equals(""))
            return null;
        char[] arr = needle.toCharArray();
        int[] next = makeNext(arr);

        for(int i = 0, j = 0, end = haystack.length(); i < end;){
            if(j == -1 || haystack.charAt(i) == arr[j]){
                j++;
                i++;
                if(j == arr.length)
                    return haystack.substring(i - arr.length);
            }
            if(i < end && haystack.charAt(i) != arr[j])
                j = next[j];
        }
        return null;
    }

    private int[] makeNext(char[] arr){
        int len = arr.length;
        int[] next = new int[len];

        next[0] = -1;
        for(int i = 0, j = -1; i + 1 < len;){
            if(j == -1 || arr[i] == arr[j]){
                next[i+1] = j+1;
                if(arr[i+1] == arr[j+1])
                    next[i+1] = next[j+1];
                i++;
                j++;
            }
            if(arr[i] != arr[j])
                j = next[j];
        }

        return next;
    }
}
