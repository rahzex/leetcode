package com.leetcode.easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.collections.TreeNode;

public class LevelOrderTraversal {

    public void traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode = root;
        queue.add(root);
        while (queue.peek() != null) {
            queue.add(currentNode.left);
            queue.add(currentNode.right);
            System.out.println(queue.poll());
        }
    }
}
