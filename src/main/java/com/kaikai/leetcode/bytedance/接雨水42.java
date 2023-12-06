package com.kaikai.leetcode.bytedance;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/28 15:55
 * Modified By:
 */
public class 接雨水42 {
    //双指针，解题很妙  搞懂为啥双指针能解决问题，这题会很简单

    public static int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int count = 0;
        while (i < j) {
            if (height[i] >= maxLeft) {
                maxLeft = height[i];
            }

            if (height[j] >= maxRight) {
                maxRight = height[j];
            }

            if (maxLeft < maxRight) {
                count = count + maxLeft - height[i];
                i++;
            } else {
                count = count + maxRight - height[j];
                j--;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trap(height1));
    }
}
