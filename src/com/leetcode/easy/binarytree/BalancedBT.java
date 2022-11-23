package com.leetcode.easy.binarytree;

import com.leetcode.collections.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree
// https://www.youtube.com/watch?v=Yt50Jfbd8Po

public class BalancedBT {

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    int dfsHeight(TreeNode node) {
        if (null == node)
            return 0;

        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
