package com.kaikai.leetcode.bytedance;

public class 环形链表141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
                if (fast == slow) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }


//    ListNode listNode6 = new ListNode(6);
//    ListNode listNode3 = new ListNode(3, listNode6);
//    ListNode listNode4 = new ListNode(4, listNode3);
//    ListNode listNode5 = new ListNode(5, listNode4);
//    ListNode listNode2 = new ListNode(2, listNode5);
//    ListNode listNode7 = new ListNode(7, listNode2);
//    ListNode listNode9 = new ListNode(9, listNode7);

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