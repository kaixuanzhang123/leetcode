package com.kaikai.leetcode.bytedance;

public class 快速排序912 {

    public static int[] sort(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }
    public static void quickSort(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        if (low > high) {
            return;
        }
        int start = nums[low];
        int temp;

        while (i < j) {
            while (start <= nums[j] && i < j) {
                j--;
            }
            while (start >= nums[i] && i < j) {
                i++;
            }
            if (i < j) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        nums[low] = nums[j];
        nums[j] = start;

        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int curr = a[low];
        int temp;
        while (i < j) {
            if (curr <= a[j] && i < j) {
                j--;
            }
            else if(curr >= a[i]) {
                i++;
            }
            else   {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[low] = a[j];
        a[j] = curr;
        sort(a, low, i);
        sort(a, i + 1, high);
    }


    public static void main(String[] args) {
        int[] num = new int[]{5, 1, 1, 2, 0, 0};
        int[] sort = sort(num);
        for (int i : sort) {
            System.out.println(i);
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