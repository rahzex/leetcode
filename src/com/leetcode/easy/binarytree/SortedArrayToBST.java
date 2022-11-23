package com.leetcode.easy.binarytree;

import com.leetcode.collections.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
// revise

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? null : convertToBST(nums, 0, nums.length);
    }

    private TreeNode convertToBST(int[] nums, int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = convertToBST(nums, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = convertToBST(nums, mid + 1, end);

        return node;
    }
}
