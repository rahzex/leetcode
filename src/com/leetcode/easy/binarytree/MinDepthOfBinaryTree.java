package com.leetcode.easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.collections.TreeNode;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class MinDepthOfBinaryTree {

    // with bfs, better solution
    public int minDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        int depth = 1;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                root = nodes.poll();
                if (root.left == null && root.right == null) {
                    return depth;
                }
                if (root.left != null)
                    nodes.offer(root.left);
                if (root.right != null)
                    nodes.offer(root.right);
            }
            depth++;
        }
        return depth;
    }

    // with dfs, not recommended
    public int minDepthDfs(TreeNode root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = minDepthDfs(root.left);
            int rheight = minDepthDfs(root.right);

            //System.out.println("lheight :" + lheight + "rheight : " + rheight)
            /* use the smaller one */
            if (lheight < rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

}
