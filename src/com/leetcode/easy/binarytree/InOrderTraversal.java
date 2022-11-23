package com.leetcode.easy.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.collections.TreeNode;

// https://leetcode.com/problems/binary-tree-inorder-traversal
// https://youtu.be/IpyCqRmaKW4

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderValues = new ArrayList<>();
        traverse(root, inorderValues);
        return inorderValues;
    }

    public void traverse(TreeNode root, List<Integer> inorderValues) {
        if (root == null)
            return;
        traverse(root.left, inorderValues);
        inorderValues.add(root.val);
        traverse(root.right, inorderValues);
    }

}
