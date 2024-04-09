package com.kaikai.leetcode.interviewTop100;

public class 验证二叉搜索树98 {

    // 解法错误  只考虑了一层的解法，没有考虑到多层的情况
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = root.left.val;
        }
        if (root.right != null) {
            right = root.right.val;
        }
        return (left < val && val < right) && isValidBST1(root.left) && isValidBST1(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //正确解法-------------------------------------------------
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST1(root));
    }

    public static class TreeNode {
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
