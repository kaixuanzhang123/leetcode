package com.kaikai.leetcode;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/29 10:16
 * Modified By:
 */
public class 搜索旋转排序数组33 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] > target && nums[end] < target) {
            return -1;
        }


        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                //左边有序
                if (nums[mid] > target && nums[0] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //右边有序
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target, int l, int r) {
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        int mid = (r + l) / 2;

        if (nums[mid] > target) {
            return search(nums, target, l, mid - 1);
        }
        if (nums[mid] < target) {
            return search(nums, target, mid + 1, r);
        }
        if (nums[mid] == target) {
            return mid;
        }
        return -1;
    }

    public static int binarySearch1(int[] arr, int data) {
        if (arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] < data) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(search(arr, 1));
    }
}
