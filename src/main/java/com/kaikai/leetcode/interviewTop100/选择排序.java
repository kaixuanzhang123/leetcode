package com.kaikai.leetcode.interviewTop100;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 14:02
 * Modified By:
 */
public class 选择排序 {
    public static int[] sortArray(int[] nums) {
        sort1(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort1(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int temp;
        while (i < j) {
            if (a[low] <= a[j]) {
                j--;
            } else if (a[low] >= a[i]) {
                i++;
            } else {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int curr = a[low];
        a[low] = a[j];
        a[j] = curr;
        sort1(a, low, i);
        sort1(a, i + 1, high);
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,4,5,6};
        sortArray(nums);
    }
}
