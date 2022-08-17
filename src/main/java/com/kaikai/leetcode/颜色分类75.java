package com.kaikai.leetcode;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/17 14:24
 * Modified By:
 */

/***
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 输入：nums = [2,0,2,1,1,0]
 输出：[0,0,1,1,2,2]
 */
public class 颜色分类75 {

    //两次遍历  不是最优解
//    public static void sortColors(int[] nums) {
//        sortColors(nums, 0);
//        sortColors(nums, 1);
//    }
//    public static void sortColors(int[] nums, int num) {
//        int i = 0;
//        int j = nums.length - 1;
//        while (i < j) {
//            while (nums[i] <= num && i < j) {
//                i++;
//            }
//            while (nums[j] != num && i < j) {
//                j--;
//            }
//            if (i < j) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//        }
//    }

    public static void sortColors(int[] nums) {
        if (nums.length > 1) {
            int p0 = 0;
            int p1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    p1++;
                } else if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    p0++;
                    if (nums[p1] > nums[i] && p0 <= p1) {
                        int temp1 = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp1;
                    }
                    p1++;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
