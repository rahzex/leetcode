package com.leetcode.easy.bitwise;

// https://leetcode.com/problems/number-of-1-bits

public class HammingWeight {

    /**
     * BEST SOLUTION, same as Integer.bitCount() implementation in Java
     * Returns the number of one-bits in the two's complement binary representation of the specified int value.
     * This function is sometimes referred to as the population count.
     * Params:
     * i – the value whose bits are to be counted
     * Returns:
     * the number of one-bits in the two's complement binary representation of the specified int value.
     */
    public int hammingWeight2(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    /**
     * Explanation for below hammingWeight1():
     * n = 23 = {10111}2 .
     * 1. Initially, count = 0.
     * 2. Now, n will change to n&(n-1). As n-1 = 22 = {10110}2 , then n&(n-1) will be {101112 & {10110}2, which will be {10110}2 which is equal to 22.
     *    Therefore, n will change to 22 and count to 1.
     * 3. As n-1 = 21 = {10101}2 , then n&(n-1) will be {10110}2 & {10101}2, which will be {10100}2 which is equal to 20.
     *    Therefore, n will change to 20 and count to 2.
     * 4. As n-1 = 19 = {10011}2 , then n&(n-1) will be {10100}2 & {10011}2, which will be {10000}2 which is equal to 16.
     *    Therefore, n will change to 16 and count to 3.
     * 5. As n-1 = 15 = {01111}2 , then n&(n-1) will be {10000}2 & {01111}2, which will be {00000}2 which is equal to 0.
     *    Therefore, n will change to 0 and count to 4.
     * 6. As n = 0, the the loop will terminate and gives the result as 4.
     *
     * Complexity: O(K), where K is the number of ones present in the binary form of the given number.
     */
    public static int hammingWeight1(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int hammingWeight(int n) {
        int smask = 1; // in binary = 00000000000000000000000000000001
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & smask) != 0)   // & operator o/p 1 only if both bits are 1, thus checking if current bit is 1 or not
                count++;
            smask <<= 1;            // shifts 1 to left on every iteration to check next bit
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count : " + hammingWeight(00000000000000000000000000001011));
        System.out.println(Integer.bitCount(11));
    }
}
