package com.kaikai.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层序遍历102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.addLast(poll.left);
                }
                if (poll.right != null) {
                    queue.addLast(poll.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        //执行层序遍历方法
        List<List<Integer>> lists = levelOrder(t);
        System.out.println(lists);
    }


    private static class TreeNode {
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