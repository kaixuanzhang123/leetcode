package com.kaikai.leetcode.baidu;

/**
 * Package: com.kaikai.leetcode.baidu
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/5 9:14
 * Modified By:
 */
public class 平衡二叉树110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = deeepLen(root.left);
        int right = deeepLen(root.right);
        return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int deeepLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deeepLen(root.left);
        int right = deeepLen(root.right);
        return Math.max(right, left) + 1;
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
