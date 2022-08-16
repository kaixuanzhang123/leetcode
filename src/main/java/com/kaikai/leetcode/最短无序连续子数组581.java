package com.kaikai.leetcode;

/**
 * Package: code
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/12 14:43
 * Modified By:
 */
public class 最短无序连续子数组581 {
    public static int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0, end = -1;
        //遍历
        for(int i = 0; i < len; i++){
            if(nums[i] < max){      //从左到右维持最大值，寻找右边界end
                end = i;
            }else{
                max = nums[i];
            }

            if(nums[len-i-1] > min){    //从右到左维持最小值，寻找左边界begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return end-begin+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,10, 2, 3, 4};
        System.out.println(findUnsortedSubarray(nums));
    }
}
