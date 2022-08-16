package com.kaikai.leetcode;

public class 最长重复子数组718 {

    public int findLength(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
    }

    public int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length, bn = B.length;
        for (int len = 1; len <= an; len++) {
            max = Math.max(max, maxLen(A, 0, B, bn - len, len));
        }
        for (int j = bn - an; j >= 0; j--) {
            max = Math.max(max, maxLen(A, 0, B, j, an));
        }
        for (int i = 1; i < an; i++) {
            max = Math.max(max, maxLen(A, i, B, 0, an - i));
        }
        return max;
    }


    public int maxLen(int[] a, int i, int[] b, int j, int len) {
        int count = 0, max = 0;
        for (int k = 0; k < len; k++) {
            if (a[i + k] == b[j + k]) {
                count++;
            } else if (count > 0) {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }


}