package com.kaikai.leetcode;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/28 18:32
 * Modified By:
 */
public class 最长递增子序列300 {
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
    }
}
