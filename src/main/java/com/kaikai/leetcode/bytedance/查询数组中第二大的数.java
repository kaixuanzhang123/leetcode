package com.kaikai.leetcode.bytedance;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/24 16:44
 * Modified By:
 */
public class 查询数组中第二大的数 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4, 7, 8};

        int[] res = new int[2];

        if (nums.length <= 1) {
            return;
        }

        res[0] = nums[0] <= nums[1] ? nums[0] : nums[1];
        res[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > res[1]) {
                res[0] = res[1];
                res[1] = nums[i];
            } else if (nums[i] > res[0]) {
                res[0] = nums[i];
            }
        }
        System.out.println(res[0]);
    }
}
