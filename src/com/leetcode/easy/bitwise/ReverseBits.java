package com.leetcode.easy.bitwise;

// https://leetcode.com/problems/reverse-bits/
// https://www.youtube.com/watch?v=-5z9dimxxmI

public class ReverseBits {

    public int reverseBits(int n) {
        n = n >>> 16 | n << 16; //2byte swap
        n = (n & 0xff00ff00) >>> 8 | (n & 0x00ff00ff) << 8; //1byte swap
        n = (n & 0xf0f0f0f0) >>> 4 | (n & 0x0f0f0f0f) << 4; //4bit swap
        n = (n & 0xcccccccc) >>> 2 | (n & 0x33333333) << 2; //2bit swap
        n = (n & 0xaaaaaaaa) >>> 1 | (n & 0x55555555) << 1; //1bit swap

        return n;
    }

    public int reverseBits1(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) { // Loop for each of the 32 bit
            result <<= 1;             // left shift result (multiply by 2)
            result += n & 1;          // If bit in n is set(i.e 1) then do same in result (add 1)
            n >>= 1;                  // right shift n (divide by 2)
        }
        return result;
    }

    public int reverseBits2(int n) {
        return Integer.reverse(n);
    }
}
