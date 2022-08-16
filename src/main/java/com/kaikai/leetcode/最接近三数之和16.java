package com.kaikai.leetcode;

import java.util.Arrays;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/27 14:56
 * Modified By:
 */
public class 最接近三数之和16 {
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int flag = 0;
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    return target;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                        min = Math.min(Math.abs(nums[i] + nums[j] + nums[k] - target), min);
                        flag = nums[i] + nums[j] + nums[k] - target > 0 ? 1 : 0;
                    }
                    k--;
                } else {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                        min = Math.min(Math.abs(nums[i] + nums[j] + nums[k] - target), min);
                        flag = nums[i] + nums[j] + nums[k] - target > 0 ? 1 : 0;
                    }
                    j++;
                }
            }

        }
        return flag > 0 ? target + min : target - min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        System.out.println(threeSumClosest(nums, 1));
    }
}
