package com.kaikai.leetcode;

/**
 * Package: code
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/4 10:29
 * Modified By:
 */
public class 打家劫舍二213 {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] - nums[1] > 0 ? nums[0] : nums[1];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public static int rob(int[] nums, int start, int end) {
        if (end - start == 1) {
            return nums[start] - nums[end] > 0 ? nums[start] : nums[end];
        }
        if (nums.length == 2) {
            return Math.max(Math.max(nums[start], nums[start + 1]), nums[start + 2]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < end - start + 1; i++) {
            dp[i] = Math.max(dp[i - 2]+nums[start+i], dp[i - 1]);
        }
        return dp[end - start];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
