package com.kaikai.leetcode;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/30 19:49
 * Modified By:
 */
public class 排序数组中查找数字 {

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 1 : -1;
        }
        int i = binarySearch(nums, target, 0, nums.length - 1);
        if (i == -1) {
            return -1;
        } else {
            int r = i;
            while (r <= nums.length - 1 && nums[r] == target) {
                r++;
            }
            int l = i;
            while (l >= 0 && nums[l] == target) {
                l--;
            }
            return r - l - 1;
        }
    }

    public static int binarySearch(int[] nums, int target, int l, int r) {
        if (r <= l) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, l, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,2};
        System.out.println(search(num, 1));
    }
}
