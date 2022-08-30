package com.kaikai.leetcode.interviewTop100;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/30 16:44
 * Modified By:
 */
public class 删除有序数组中的重复项26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 1;
        int j = 1;
        int start = nums[0];
        while (j < nums.length) {
            if (nums[j] == start) {
                j++;
            } else {
                nums[i] = nums[j];
                start = nums[j];
                i++;
                j++;
            }
        }
        return i ;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
