package com.kaikai.leetcode;

/**
 * Package: code
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/2 9:28
 * Modified By:
 */
public class 合并两个有序数组88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[k] = nums2[j];
                k--;
                j--;
            } else if (j == -1) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    public static void merge(int[] nums1, int[] nums2, int m, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[k] = nums2[j];
                k--;
                j--;
            } else if (j == -1) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums1={1,2,3,0,0,0};
//        int[] nums2={2,5,6};
//        merge(nums1,3,nums2,3);
//        for (int i : nums1) {
//            System.out.println(i);
//        }

        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

}
