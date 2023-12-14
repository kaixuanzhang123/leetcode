package com.kaikai.leetcode.interviewTop100;

import javax.lang.model.element.VariableElement;

public class 轮转数组189 {
    //解法一
    public static void rotate1(int[] nums, int k) {
        int[] res = new int[nums.length];
        int r = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i > r) {
                res[r + i] = nums[i];
            } else {
                res[i + r - nums.length] = nums[i];
            }
        }
        for (int j = 0; j < res.length; j++) {
            nums[j] = res[j];
        }
    }

//    进阶：
//    你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

    //解法二  把最后的数移动到最前面  ----------结果超时
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

    //方法三  3次翻转数组 k=2 {1, 2, 3, 4,5} -> {5,4,3,2,1} -> {3,4,1,2}
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    public static void swap(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
