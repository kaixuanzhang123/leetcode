package com.kaikai.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/28 14:26
 * Modified By:
 */
public class 螺旋矩阵54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        boolean[][] dp = new boolean[m + 1][n + 1];
        int i = 0, j = 0;
        while (i < m && j < n && res.size() < m * n) {
            while (!dp[i][j] && j < n) {
                res.add(matrix[i][j]);
                dp[i][j] = true;
                j++;
            }
            j--;
            i++;
            while (!dp[i][j] && i < m) {
                res.add(matrix[i][j]);
                dp[i][j] = true;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && !dp[i][j]) {
                res.add(matrix[i][j]);
                dp[i][j] = true;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && !dp[i][j]) {
                res.add(matrix[i][j]);
                dp[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> integers = spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }
}
