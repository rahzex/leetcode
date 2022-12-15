package com.leetcode.medium;

import com.leetcode.collections.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val == q.val || root.val == p.val) {
                return root;
            }

            if((root.val > q.val && root.val < p.val) || (root.val > p.val && root.val < q.val)) {
                return root;
            }

            if(root.val > q.val && root.val > p.val) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return root;
    }

    // refactored to reduce unnecessary checks
    public TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val > q.val && root.val > p.val) {
                root = root.left;
            }
            else if(root.val < q.val && root.val < p.val){
                root = root.right;
            }
            else
                return root;
        }
        return root;
    }
}
