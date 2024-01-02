package com.kaikai.leetcode.interviewTop100;

public class 反转链表206 {


    public static ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = dummy;
            dummy = temp;
            head = head.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();

        head.val = 1;
        node1.val = 2;
        node2.val = 3;
        node3.val = 4;

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode result = reverseList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}