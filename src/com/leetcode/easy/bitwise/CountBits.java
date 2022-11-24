package com.leetcode.easy.bitwise;

// https://leetcode.com/problems/counting-bits
// https://www.youtube.com/watch?v=awxaRgUB4Kw
// https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/

public class CountBits {

    // T O(n), S O(n)
    public int[] countBitsBetter(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++)
            f[i] = f[i >> 1] + (i & 1); // same as  f[i] = f[i / 2] + i % 2.
        return f;
    }

    // T O(n logM) where M = max number of bits set
    // S O(n)
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    private int countOnes(int n) {
        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
