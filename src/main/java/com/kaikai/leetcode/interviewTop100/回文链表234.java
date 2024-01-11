package com.kaikai.leetcode.interviewTop100;

public class 回文链表234 {

    //你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
    public static boolean isPalindrome(ListNode head) {
        //1.找中间节点  2.反转  3.比较
        ListNode dummy = new ListNode(-1, head);
        ListNode slowList = dummy.next;
        ListNode fastList = dummy.next;
        while (fastList != null && fastList.next != null) {
            slowList = slowList.next;
            fastList = fastList.next.next;
        }
        ListNode reversNode = reversList(slowList);
        while (reversNode != null) {
            if (reversNode.val != head.val) {
                return false;
            }
            reversNode = reversNode.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reversList(ListNode head) {
        ListNode dummy = head;
        ListNode pre = null;
        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = next;
        }
        return pre;
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

        System.out.println(isPalindrome(head));
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
