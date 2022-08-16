package com.kaikai.leetcode;

public class 链表中第K个节点 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dumy = head;
        for (int i = 0; i < k; i++) {
            dumy = dumy.next;
        }
        ListNode slow = head;
        ListNode fast = dumy;
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
       return slow;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(7);
        ListNode listNode3 = new ListNode(6, listNode6);
        ListNode listNode4 = new ListNode(5, listNode3);
        ListNode listNode5 = new ListNode(4, listNode4);
        ListNode listNode2 = new ListNode(3, listNode5);
        ListNode listNode7 = new ListNode(2, listNode2);
        ListNode listNode9 = new ListNode(1, listNode7);

        ListNode listNode = getKthFromEnd(listNode9,3);
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