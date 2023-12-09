package com.kaikai.leetcode.interviewTop100;

import java.util.HashMap;
import java.util.Map;

//    给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//    子数组是数组中元素的连续非空序列。
public class 和为k的子数组560 {
    //注意是 连续非空序列
    public static int subarraySum1(int[] nums, int k) {
        int resCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j >= 0; j--) {
                count += nums[j];
                if (count == k) {
                    resCount++;
                }
            }
        }
        return resCount;
    }

    //优化 由于是连续数组
    //如果 存在k满足条件，k=count[j]-count[i]
    public static int subarraySum(int[] nums, int k) {
        //1.遍历一次数组求和
        //问题转化成数组中存在两个数求差值，等于另一个数K，利用hashmap简化计算

        int pre = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //关键 这种带0的情况需要{1, -1, 0}
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count = count + map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 1, 1};
        //int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{0,1, -1, 0};
        System.out.println(subarraySum(nums, 0));
    }
}
