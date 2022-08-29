package com.kaikai.leetcode.interviewTop100;

import java.awt.*;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/29 20:51
 * Modified By:
 */
public class 盛最多水的容器11 {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                max=Math.max(max,height[i]*(j-i));
                i++;
            }else {
                max=Math.max(max,height[j]*(j-i));
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
