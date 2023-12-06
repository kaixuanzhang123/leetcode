package com.kaikai.leetcode.interviewTop100;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/30 16:58
 * Modified By:
 */
public class 删除排序链表中的重复元素83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode(-1, head);
        ListNode node = dump.next;

        while (node != null) {
            int val = node.val;
            while (node.next != null && val == node.next.val) {
                node.next = node.next.next;
            }
            node=node.next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(7);
        ListNode listNode3 = new ListNode(4, listNode6);
        ListNode listNode4 = new ListNode(3, listNode3);
        ListNode listNode5 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode5);
        ListNode listNode7 = new ListNode(2, listNode2);
        ListNode listNode9 = new ListNode(1, listNode7);

        ListNode listNode = deleteDuplicates(listNode9);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
