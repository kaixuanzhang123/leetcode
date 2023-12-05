package com.kaikai.leetcode.bytedance;

public class 反转链表92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        ListNode rightNode = pre.next;
        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }
        ListNode end = rightNode.next;
        rightNode.next = null;
        ListNode listNode = reverseNode(leftNode);
        pre.next = listNode;
        leftNode.next = end;
        return dummy.next;
    }

    public static ListNode reverseNode(ListNode head) {
        ListNode pre = head;
        ListNode dum = null;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = dum;
            dum = pre;
            pre = next;
        }
     return dum;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(5);
        ListNode listNode5 = new ListNode(4, listNode6);
        ListNode listNode2 = new ListNode(3, listNode5);
        ListNode listNode7 = new ListNode(2, listNode2);
        ListNode listNode9 = new ListNode(1, listNode7);

        ListNode listNode = reverseBetween(listNode9, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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