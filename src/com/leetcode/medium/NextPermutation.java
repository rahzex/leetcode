package com.leetcode.medium;

class NextPermutation {
    /**
     *  [2 1 5 3 1 0]
     *  Intuition:
     *  Find breaking point where arr[i] < arr[i+1]
     *  [2 1 | 5 4 3 2 0]
     *  find the smallest value from arr[i+1] to arr[n] which is greater than a[i]
     *  [...5 4 3 {2} 0]
     *  swap the smallest value at arr[i],
     *  [2 {2} 5 4 3 {1} 0]
     *  fill remaining places with values in increasing order i.e. reverse
     *  [2 2 {0 1 3 4 5}]
     *  TC: O(n)
     *  SC: O(1)
     */

    public void nextPermutation(int[] nums) {
        // find breaking point where arr[i] < arr[i+1]
        int breakingIndex = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                breakingIndex = i - 1;
                break;
            }
        }
        // breaking index not found i.e. array is sorted in decreasing order
        if(breakingIndex == -1) {
            //reverse the array
            reverse(nums, 0, nums.length - 1);
        } else {
            // find the smallest value from arr[i+1] to arr[n] which is greater than a[i].
            for(int j = nums.length - 1; j > breakingIndex; j--) {
                if(nums[j] > nums[breakingIndex]) {
                    int temp = nums[breakingIndex];
                    nums[breakingIndex] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            // fill remaining places with values in increasing order.
            reverse(nums, breakingIndex + 1, nums.length - 1);
        }
    }

    void reverse(int[] arr, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
