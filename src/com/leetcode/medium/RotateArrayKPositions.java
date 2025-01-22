package com.leetcode.medium;

import java.util.Arrays;

public class RotateArrayKPositions {
    /**
     * Input: arr = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     *
     * Intuition: reverse the array, [7,6,5,4,3,2,1]
     * then reverse the first k positions [5,6,7,4,3,2,1]
     * then reverse the remaining positions [5,6,7,1,2,3,4]
     *
     * 6712345
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr, 3);
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void rotate(int[] arr, int k){
        k = k % arr.length; // this is required when k >= arr.length
        System.out.println(k);
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }
}
