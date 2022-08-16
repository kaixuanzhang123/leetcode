package com.kaikai.leetcode;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/28 15:02
 * Modified By:
 */
public class 重排链表143 {
    public static void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy.next;
        ListNode fast = dummy.next;
        ListNode slow = dummy.next;

        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode node2 = slow.next;
        slow.next = null;
        ListNode reverse = reverse(node2);
        merge(pre, reverse);
    }

    public static ListNode reverse(ListNode head) {
        ListNode dummy = head;
        ListNode pre = null;
        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = next;
        }
        return  pre;
    }

    public static void merge(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;
            list1.next = list2;
            list2.next = next1;
            list1 = list1.next.next;
            list2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(7);
        ListNode listNode3 = new ListNode(6, listNode6);
        ListNode listNode4 = new ListNode(5, listNode3);
        ListNode listNode5 = new ListNode(4, listNode4);
        ListNode listNode2 = new ListNode(3, listNode5);
        ListNode listNode7 = new ListNode(2, listNode2);
        ListNode listNode9 = new ListNode(1, listNode7);

        reorderList(listNode9);

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
