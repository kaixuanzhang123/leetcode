package com.kaikai.leetcode.interviewTop100;

public class 移动零283 {
    //错误解题思路，无法解决 int[] nums = new int[]{0, 0, 1}这样的数据
    public static void moveZeroesError(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    //正确解题思路
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swp(nums, i, j);
                j++;
            }
        }
    }

    public static void swp(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 3, 12};
        //int[] nums = new int[]{0, 0, 1};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

