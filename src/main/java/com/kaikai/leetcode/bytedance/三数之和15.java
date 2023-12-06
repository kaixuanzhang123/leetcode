package com.kaikai.leetcode.bytedance;

import java.util.*;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/30 20:52
 * Modified By:
 */
public class 三数之和15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int three = nums.length - 1;
            while (j < three) {
                List<Integer> list = new ArrayList<>();
                if (nums[i] + nums[j] + nums[three] == 0) {
                    String flag = nums[i] + "" + nums[j] + "" + nums[three];
                    if (!map.containsKey(flag)) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[three]);
                        res.add(list);
                        map.put(flag, 1);
                    }
                    j++;
                }
                if (nums[i] + nums[j] + nums[three] < 0) {
                    j++;
                }
                if (nums[i] + nums[j] + nums[three] > 0) {
                    three--;
                }
            }
        }
        return res;
    }
}
