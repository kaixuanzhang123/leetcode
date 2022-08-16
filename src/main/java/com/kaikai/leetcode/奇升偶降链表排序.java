package com.kaikai.leetcode;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: ZHANGKAIXUAN
 * Date:  2022/7/30 16:31
 * Modified By:
 */
public class 奇升偶降链表排序 {

    public static ListNode getLists(ListNode head) {
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode list1 = first;
        ListNode list2 = second;
        int flag = 1;
        while (head != null) {
            if (flag % 2 != 0) {
                list1.next = new ListNode(head.val);
                list1 = list1.next;
            } else {
                list2.next = new ListNode(head.val);
                list2 = list2.next;
            }
            head = head.next;
            flag++;
        }
        ListNode reversList = reversList(second.next);
        ListNode listNode = megerLists(first.next, reversList);
        return listNode;
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

    public static ListNode megerLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                dummy.next = list2;
                break;
            } else if (list2 == null) {
                dummy.next = list1;
                break;
            } else if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = init();
        ListNode lists = getLists(head);

        while (lists != null) {
            System.out.println(lists.val);
            lists = lists.next;
        }
    }

    public static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
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
