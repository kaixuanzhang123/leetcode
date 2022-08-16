package com.kaikai.leetcode;

public class 删除链表的倒数第N个结点19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy.next;
        ListNode slow = dummy.next;
        for (int i = 0; i < n+1; i++) {
            if (pre==null) {
                return head.next;
            }
            pre = pre.next;
        }

        while (pre!=null){
            pre=pre.next;
            slow=slow.next;
        }

        if (slow.next!=null) {
            slow.next=slow.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(7);
        ListNode listNode3 = new ListNode(6, listNode6);
        ListNode listNode4 = new ListNode(5, listNode3);
        ListNode listNode5 = new ListNode(4, listNode4);
        ListNode listNode2 = new ListNode(3, listNode5);
        ListNode listNode7 = new ListNode(2, listNode2);
        ListNode listNode9 = new ListNode(1, listNode7);

        ListNode listNode = removeNthFromEnd(listNode6, 1);
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