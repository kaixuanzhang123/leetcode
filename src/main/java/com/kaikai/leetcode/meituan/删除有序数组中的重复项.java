package com.kaikai.leetcode.meituan;

public class 删除有序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j-1] != nums[j]) {
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
