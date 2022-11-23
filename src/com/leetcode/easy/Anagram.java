package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static boolean isAnagram(String a, String b) {

        if (a.length() != b.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        char c;
        int count;

        for (int i = 0; i < a.length(); i++) {
            c = a.charAt(i);
            if (map.containsKey(c)) {
                count = map.get(c);
                map.put(c, ++count);
            }
            else {
                map.put(c, 1);
            }

            c = b.charAt(i);
            if (map.containsKey(c)) {
                count = map.get(c);
                map.put(c, --count);
            }
            else {
                map.put(c, -1);
            }
        }

        for (int co : map.values()) {
            if (co != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("éat", "aét"));
    }
}
