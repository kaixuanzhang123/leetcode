package com.kaikai.leetcode.interviewTop100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的最大深度104 {
    //递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    //非递归实现
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        int ant = 0;
        deque.offer(root);
        while (deque.size() > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.right != null) {
                    deque.add(poll.right);
                }
                if (poll.left != null) {
                    deque.add(poll.left);
                }
            }
            ant++;
        }
        return ant;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(maxDepth2(root));
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
