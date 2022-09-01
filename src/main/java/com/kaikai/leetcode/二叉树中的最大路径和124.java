package com.kaikai.leetcode;

import sun.util.resources.cldr.fr.CalendarData_fr_MQ;

import javax.swing.tree.TreeNode;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 23:07
 * Modified By:
 */
public class 二叉树中的最大路径和124 {
    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(-2);
        t.left = new TreeNode(-1);
        t.right = null;

        System.out.println(maxPathSum(t));
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
