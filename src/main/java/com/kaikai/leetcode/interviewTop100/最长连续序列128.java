package com.kaikai.leetcode.interviewTop100;

import java.util.HashSet;

public class 最长连续序列128 {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            //这一步是关键，没有这一步的排除 会超时
            if (!set.contains(num - 1)) {
                int start = num;
                int maxCount = 1;
                while (set.contains(start + 1)) {
                    start++;
                    maxCount++;
                }
                res = Math.max(res, maxCount);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        //int[] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
