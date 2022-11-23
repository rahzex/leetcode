package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/jewels-and-stones

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int jewelCount = 0;
        Set<Character> j = new HashSet<>();

        for (char jewel : jewels.toCharArray()) {
            j.add(jewel);
        }

        for (char stone : stones.toCharArray()) {
            if (j.contains(stone))
                jewelCount++;
        }
        return jewelCount;
    }

    public int numJewelsInStonesBetter(String jewels, String stones) {
        int[] jewel = new int[128];

        // jewels = Abh
        // stones = Hcboh
        for (char c: jewels.toCharArray()) {
            jewel[c]++;
        }

        int res = 0;
        for (char c:  stones.toCharArray()) {
            res += jewel[c];
        }

        return res;
    }
}
