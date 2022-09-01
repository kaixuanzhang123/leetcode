package com.kaikai.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 16:08
 * Modified By:
 */
public class 全排列46 {

    static List<List<Integer>> resList = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtracking(nums.length - 1, 0, list);
        return resList;
    }

    public static void backtracking(int len, int index, List<Integer> list) {
        if (len == index) {
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            resList.add(arrayList);
        }
        for (int i = index; i <= len; i++) {
            Collections.swap(list, index, i);
            backtracking(len, index + 1, list);
            Collections.swap(list, i, index);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }
    }
}
