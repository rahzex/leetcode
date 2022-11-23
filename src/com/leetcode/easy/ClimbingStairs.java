package com.leetcode.easy;

public class ClimbingStairs {

    // https://leetcode.com/problems/climbing-stairs

    public static int climbStairs(int n) {

        if(n <= 2) {
            return n;
        }
        int fib = 2;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

}
