package com.leetcode.easy.binarytree;

import java.util.Stack;

import com.leetcode.collections.TreeNode;

// https://leetcode.com/problems/symmetric-tree

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    // recursive solution
    public boolean isSymmetric(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else if (node1.val != node2.val)
            return false;
        else
            return isSymmetric(node1.right, node2.left) && isSymmetric(node1.left, node2.right);
    }

    // iterative solution
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null || n1.val != n2.val)
                return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}
