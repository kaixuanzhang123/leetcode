package com.kaikai.leetcode;

import java.nio.charset.MalformedInputException;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 20:47
 * Modified By:
 */
public class 寻找旋转排序数组中的最小值153 {
    public static int findMin(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (nums[mid] < nums[j]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }
}
