package com.leetcode.easy.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.collections.TreeNode;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode node, List<Integer> nodes) {
        if (node == null)
            return;
        traverse(node.left, nodes);
        traverse(node.right, nodes);
        nodes.add(node.val);
    }
}
