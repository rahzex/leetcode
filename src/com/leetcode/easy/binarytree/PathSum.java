package com.leetcode.easy.binarytree;

import com.leetcode.collections.TreeNode;

public class PathSum {

    // my solution with sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return findSum(root, targetSum, 0) == -1001;
    }

    public int findSum(TreeNode root, int targetSum, int currentSum) {
        if (root.left == null && root.right == null)
            return currentSum + root.val == targetSum ? -1001 : 0;

        currentSum += root.val;

        int leftSum = root.left == null ? 0 : findSum(root.left, targetSum, currentSum);
        if (leftSum == -1001)
            return -1001;

        int rightSum = root.right == null ? 0 : findSum(root.right, targetSum, currentSum);
        if (rightSum == -1001)
            return -1001;

        return currentSum - root.val;
    }

    // compact and easy solution with subtraction
    public boolean hasPathSumBetter(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null)
            return targetSum == 0;
        return hasPathSumBetter(root.left, targetSum) || hasPathSumBetter(root.right, targetSum);
    }
}
