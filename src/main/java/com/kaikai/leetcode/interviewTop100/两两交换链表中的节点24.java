package com.kaikai.leetcode.interviewTop100;

import java.time.Period;

public class 两两交换链表中的节点24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null) {
            ListNode nextNode = head.next;
            if (nextNode != null) {
                ListNode teo = nextNode.next;
                pre.next = new ListNode(nextNode.val);
                pre.next.next = new ListNode(head.val);
                pre = pre.next.next;
                head = teo;
            } else {
                pre.next = new ListNode(head.val);
                pre = pre.next;
                head = nextNode;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        //ListNode node3 = new ListNode();
        head.val = 1;
        node1.val = 2;
        node2.val = 3;
        //node3.val = 4;
        head.next = node1;
        node1.next = node2;
        //node2.next = node3;
        ListNode swapPairs = swapPairs(head);
        while (swapPairs != null) {
            System.out.println(swapPairs.val);
            swapPairs = swapPairs.next;
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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

