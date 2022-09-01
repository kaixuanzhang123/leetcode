package com.kaikai.leetcode.interviewTop100;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 15:23
 * Modified By:
 */
public class 最大子数组和53 {
    public int maxSubArray(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int max = res[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1], nums[i]);
            max=Math.max(max,res[i]);
        }
        return max;
    }
}
