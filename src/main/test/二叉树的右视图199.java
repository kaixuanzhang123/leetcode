import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Package: code
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/10 16:50
 * Modified By:
 */
public class 二叉树的右视图199 {

    public static List<Integer> rightSideView(TreeNode root) {
        //所谓二叉树的右侧视图就是二叉树每一层最右边节点的值
        //那么既然涉及到二叉树的层的概念很自然的就使用二叉树的层次遍历
        //为了区分二叉树的每一层我们的办法就是使用两个队列来区分二叉树的每一层
        //首先两个初始化队列，其中一个队列的初始值为root节点，下层队列的初始值为空
        if (root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.offer(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        //双队列层次遍历
        while (!queue1.isEmpty()) {
            //遍历每一个节点时需要先记录下每一个节点将其从queue1中删除
            TreeNode node = queue1.poll();
            //判断其是否右左右节点，有就放入到queue2
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            //当queue1为空时，使用queue2置换queue1,queue2初始化为新的队列，这个时候的node时上一个队列的最右节点需要记录下来
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                result.add(node.val);
            }
        }
        return result;
    }


    //二叉树层序遍历的思想  比上面的方法更节省空间
    public static ArrayList<Integer> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<Integer> resList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1) {
                    resList.add(poll.val);
                }
                if (poll.left != null) {
                    queue.addLast(poll.left);
                }
                if (poll.right != null) {
                    queue.addLast(poll.right);
                }
            }
        }
        return resList;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.left.right.left = new TreeNode(6);
        t.right.right = new TreeNode(5);
        //执行层序遍历方法
        List<Integer> integers = levelOrder(t);
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
