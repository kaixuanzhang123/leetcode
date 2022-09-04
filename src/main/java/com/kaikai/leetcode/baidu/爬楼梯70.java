package com.kaikai.leetcode.baidu;

/**
 * Package: com.kaikai.leetcode.baidu
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/2 16:29
 * Modified By:
 */
public class 爬楼梯70 {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }
}
