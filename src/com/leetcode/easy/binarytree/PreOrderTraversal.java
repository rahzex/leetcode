package com.leetcode.easy.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.collections.TreeNode;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode node, List<Integer> nodes) {
        if (node == null)
            return;
        nodes.add(node.val);
        traverse(node.left, nodes);
        traverse(node.right, nodes);
    }
}
