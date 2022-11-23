package com.leetcode.easy.bitwise;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int mask = 1;
        int distance = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & mask) != (y & mask))
                distance++;
            mask <<= 1;
        }
        return distance;
    }

    public static int hammingDistanceBetter(int x, int y) {
        x = x ^ y;      // XOR gives 1 on opposite bit values only. ( 1 XOR 0 = 1 ; 0 XOR 1 = 1)
        int distance = 0;
        while (x > 0) {
            // x & (x-1) always will eliminate lsb from each iteration,
            // counting 1's in XORed number i.e == distance
            x &= x - 1;
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(2,5));
        System.out.println(hammingDistanceBetter(2,5));
        // 0010 - 0101
    }
}
