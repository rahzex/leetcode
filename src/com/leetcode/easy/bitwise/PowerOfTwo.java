package com.leetcode.easy.bitwise;

public class PowerOfTwo {

    /** Explanation :
     * Now think about x & (x-1). x & (x-1) will have all the bits equal to the x except for the rightmost 1 in x.
     * Let, x = 4 = (100)2
     * x - 1 = 3 = (011)2
     * x & (x-1) = 4 & 3 = (100)2 & (011)2 = (000)2
     * Let, x = 6 = (110)2
     * x - 1 = 5 = (101)2
     * x & (x-1) = 6 & 5 = (110)2 & (101)2 = (100)2
     *
     * Properties for numbers which are powers of 2,
     * is that they have one and only one bit set in their binary representation.
     * If the number is neither zero nor a power of two, it will have 1 in more than one place.
     * So if x is a power of 2 then x & (x-1) will be 0.
     */
    public static boolean isPowerOfTwo(int n) {
        return (n >= 0) && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2147483648));
    }
}
