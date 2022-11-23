package com.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArrays {

    // https://leetcode.com/problems/merge-sorted-array
    // in - place
    public static void mergeBest(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1 ,i = m+n-1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            }
            else{
                nums1[i--] = nums2[p2--];
            }
        }
    }

    public static void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // using additional array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m+n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            }
            else if (nums2[j] < nums1[i]) {
                result[k++] = nums2[j++];
            }
            else {
                result[k++] = nums1[i++];
                result[k++] = nums2[j++];
            }
        }

        for (; j < n; j++, k++) {
            result[k] = nums2[j];
        }

        for (; i < m; i++, k++) {
            result[k] = nums1[i];
        }

        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        merge(nums1, 0, nums2, 0);

        System.out.println(Arrays.toString(nums1));
    }
}
// k
// 1    1   2   5   6   7
//
// 1    5   6   7
// j

/* Input: nums1 = [1,2,3,4,0,0,0], m = 4,
          nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
