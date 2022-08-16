package com.kaikai.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Package: code
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/3 22:23
 * Modified By:
 */
public class 二叉树的锯齿形层序遍历103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (flag % 2 == 0) {
                    list.addLast(poll.val);
                } else {
                    list.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            flag++;
            resList.add(new LinkedList<>(list));
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        //t.left.left.right = new TreeNode(5);
        //t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(5);
        //执行层序遍历方法
        List<List<Integer>> lists = zigzagLevelOrder(t);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
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
