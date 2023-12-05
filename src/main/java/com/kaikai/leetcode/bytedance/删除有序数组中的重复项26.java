package com.kaikai.leetcode.bytedance;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/31 23:19
 * Modified By:
 */
public class 删除有序数组中的重复项26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        while (j <= nums.length - 1) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                if (j - i == 1) {
                    j++;
                    i++;
                } else {
                    i++;
                    nums[i] = nums[j];
                }
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
