package com.leetcode.easy;

public class BinarySearchInsert {

    // https://leetcode.com/problems/search-insert-position

    public int searchInsert(int[] nums, int target) {

        int low = 0, mid;
        int high = nums.length-1;

        while(low <= high){
            mid = low + (high - low) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid -1;
            else
                low = mid+1;
        }

        return low;
    }
}
