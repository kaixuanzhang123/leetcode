package com.kaikai.leetcode.bytedance;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 21:55
 * Modified By:
 */
public class 二叉树的最大深度104 {
    //基于层序遍历的思想
    public static int maxDepth(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int count = 0;
        while (root != null && deque.size() != 0) {
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
            }
        }
        return count;
    }

    //基于递归的思想 要好好体会
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = null;
        t.right.left = null;
        t.right.right = new TreeNode(5);
        //执行层序遍历方法
        int depth = maxDepth(t);
        System.out.println(depth);
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
