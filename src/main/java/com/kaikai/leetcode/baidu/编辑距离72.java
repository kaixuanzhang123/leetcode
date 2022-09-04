package com.kaikai.leetcode.baidu;

/**
 * Package: com.kaikai.leetcode.baidu
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/4 13:00
 * Modified By:
 */

/**
 * 和 最长公共子序列很像 1143
 */
public class 编辑距离72 {
    public int minDistance(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] res = new int[len1 + 1][len2 + 1];
        // 第一行
        for (int j = 1; j <= len2; j++) {
            res[0][j] = res[0][j - 1] + 1;
        }
        // 第一列
        for (int i = 1; i <= len1; i++) {
            res[i][0] = res[i - 1][0] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = Math.min(Math.min(res[i - 1][j - 1], res[i][j - 1]), res[i - 1][j]) + 1;
                }
            }
        }
        return res[len1][len2];
    }
}
