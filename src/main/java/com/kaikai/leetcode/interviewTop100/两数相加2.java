package com.kaikai.leetcode.interviewTop100;

public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int flag = 0;
        while ((l1 != null || l2 != null)) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            cur.next = new ListNode((flag + a + b) % 10);
            cur = cur.next;
            if (flag + a + b > 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (flag > 0) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l6.next = l7;
        l7.next = l8;
        ListNode result = new 两数相加2().addTwoNumbers(l1, l6);
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
