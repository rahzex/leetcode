package com.leetcode.easy;

// https://leetcode.com/problems/happy-number
// https://leetcode.com/problems/happy-number/solution/

public class HappyNumber {

    // Floyd's Cycle-Finding Algorithm
    public static boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);

        while (slowRunner != fastRunner && fastRunner != 1) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        int rem;
        while (n > 0) {
            rem = n % 10;
            n = n / 10;
            sum += rem * rem;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
