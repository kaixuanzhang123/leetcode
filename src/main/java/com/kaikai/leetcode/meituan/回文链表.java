package com.kaikai.leetcode.meituan;

import java.util.Stack;

public class 回文链表 {
    //解法一： 使用栈

    public static boolean isPalindrome1(ListNode head) {
        Stack<Integer> listNodes = new Stack<>();
        ListNode duNode = head;
        while (head != null) {
            int val = head.val;
            listNodes.add(val);
            head = head.next;
        }
        while (duNode.next != null) {
            if (duNode.val != listNodes.pop()) {
                return false;
            }
            duNode = duNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode init = init();
        System.out.println(isPalindrome1(init));
    }


    public static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }


    public static class ListNode {
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

