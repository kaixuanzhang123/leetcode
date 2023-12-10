package com.kaikai.leetcode.interviewTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i, int[] j) {
                return i[0] - j[0];
            }
        });
        //技巧：如果多重数组有添加值的操作，最好是用list,最后list转数组
        //int[][] res = new int[][]{};
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[0] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], l);
            }
        }
        return  res.toArray(new int[][]{});
    }
}
