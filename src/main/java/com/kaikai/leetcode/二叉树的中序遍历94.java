package com.kaikai.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历94 {

    static List<Integer> list = new ArrayList<>();

    //遍历法
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        return list;
    }

    //迭代法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
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
        List<Integer> integers = inorderTraversal(t);
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