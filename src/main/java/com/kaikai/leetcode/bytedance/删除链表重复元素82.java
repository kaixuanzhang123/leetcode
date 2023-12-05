package com.kaikai.leetcode.bytedance;

public class 删除链表重复元素82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1000, head);
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            if ( node.next.val == node.next.next.val) {
                int val = node.next.val;
                while (node.next.next != null && node.next.val == val) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(5);
        ListNode listNode3 = new ListNode(4, listNode6);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNode5 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(3, listNode5);
        ListNode listNode7 = new ListNode(2, listNode2);
        ListNode listNode9 = new ListNode(1, listNode7);

        ListNode listNode = deleteDuplicates(listNode9);
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