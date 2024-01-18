package com.kaikai.leetcode.interviewTop100;

public class 二叉树的直径543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dep(root);
        return max;
    }

    public int dep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        max = Math.max(max, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


