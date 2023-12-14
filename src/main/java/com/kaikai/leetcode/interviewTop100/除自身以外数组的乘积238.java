package com.kaikai.leetcode.interviewTop100;

public class 除自身以外数组的乘积238 {
    //要求：不要使用除法，且在 O(n) 时间复杂度内完成此题。
    //关键点 1.在于先遍历算一遍，后面直接找，而不是再算一遍
    //      2.为了便于计算，数组0的位置需要赋值为1
    //总结：这种类似的需要计算累加，累乘的题，都可以利用一个额外的数组，提前计算，降低时间复杂度
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] l = new int[length+1];
        int[] r = new int[length+1];
        l[0] = 1;
        r[0] = 1;
        for (int i = 0; i < length; i++) {
            l[i + 1] = nums[i] * l[i];
            r[i + 1] = nums[length - i - 1] * r[i];
        }
        for (int i = 0; i < length; i++) {
            res[i] = l[i] * r[length - i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }

}
