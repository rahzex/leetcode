package com.leetcode.easy.binarytree;

import com.leetcode.collections.TreeNode;

public class DiameterOfATree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // get max height so that it can be returned to caller method to find its height.
        int maxHeight = Math.max(leftHeight,rightHeight);
        // update diameter if current diameter is greater than previous one.
        diameter = Math.max(leftHeight + rightHeight, diameter);
        return maxHeight + 1;
    }
}
