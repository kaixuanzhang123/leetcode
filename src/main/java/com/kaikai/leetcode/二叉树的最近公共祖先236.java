package com.kaikai.leetcode;


/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 23:01
 * Modified By:
 */
public class 二叉树的最近公共祖先236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            }
            //两个都在右子树
            else if (lNode == null) {
                return rNode;
            }//两个都在左子树里面
            else {
                return lNode;
            }
        }
        return null;
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
