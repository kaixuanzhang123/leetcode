package com.kaikai.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历144 {

//    public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> resList = new ArrayList<>();
//        preorderTraversal(root,resList);
//        return resList;
//    }
//
//    public static void preorderTraversal(TreeNode root, List<Integer> resList) {
//        if (root == null) {
//            return;
//        }
//        resList.add(root.val);
//        preorderTraversal(root.left,resList);
//        preorderTraversal(root.right,resList);
//    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() > 0) {
            while (root != null) {
                resList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode peek = stack.pop();
            root = peek.right;
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
        List<Integer> integers = preorderTraversal(t);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

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