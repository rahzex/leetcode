package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings
// https://leetcode.com/discuss/interview-question/368038/Amazon-or-Onsite-or-Group-Isomorphic-Strings

public class IsomorphicStrings {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1) - since the size of the ASCII character set is fixed and the keys in our dictionary are all valid ASCII characters according to the problem statement.
    */
    public static boolean isIsomorphicBetter(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }

    /*
    Time Complexity: O(N)
    Space Complexity: O(1) - since the size of the ASCII character set is fixed and the keys in our dictionary are all valid ASCII characters according to the problem statement.
    */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character,Character> sPegT = new HashMap<>();
        Map<Character,Character> tPegS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (sPegT.containsKey(s.charAt(i))) {
                char peggedChar = sPegT.get(s.charAt(i));
                if (t.charAt(i) != peggedChar)
                    return false;
            }
            else {
                sPegT.put(s.charAt(i), t.charAt(i));
            }

            if (tPegS.containsKey(t.charAt(i))) {
                char peggedChar = tPegS.get(t.charAt(i));
                if (s.charAt(i) != peggedChar)
                    return false;
            }
            else {
                tPegS.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }

    public static boolean isIsomorphicBest(String s, String t) {
        return transform(s).equals(transform(t));
    }

    /*
    Intuition : "apple" -> 1 2 2 3 4 & "apply" -> 1 2 2 3 4
                "dog" -> 1 2 3 & cog -> 1 2 3
     */
    private static String transform(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        final String SEPARATOR = " ";

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (!indexMapping.containsKey(c)) {
                indexMapping.put(c, i);
            }

            builder.append(indexMapping.get(c));
            builder.append(SEPARATOR);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicBest("madc", "bgsf"));
    }
}
