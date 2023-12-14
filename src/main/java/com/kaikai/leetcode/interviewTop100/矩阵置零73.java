package com.kaikai.leetcode.interviewTop100;

import java.lang.invoke.VarHandle;

public class 矩阵置零73 {

    //直观解题  O(mn) 的额外空间  -----直接搞定
    public static void setZeroes(int[][] matrix) {
        int[] x = new int[matrix.length];
        int[] y = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = 1;
                    y[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (x[i] == 1 || y[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }
}
