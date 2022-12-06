package com.leetcode.easy.binarytree;

import com.leetcode.collections.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = new TreeNode();
        TreeNode head = root;
        invert(root, temp);
        return head;
    }

    // TopDown Approach : my solution
    public void invert(TreeNode root, TreeNode temp) {
        if (root != null) {
            if (root.right != null || root.left != null) {
                temp.right = root.right;
                root.right = root.left;
                root.left = temp.right;
            }
            invert(root.right, temp);
            invert(root.left, temp);
        }
    }

    //BottomUp Approach
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tempRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
        return root;
    }
}
