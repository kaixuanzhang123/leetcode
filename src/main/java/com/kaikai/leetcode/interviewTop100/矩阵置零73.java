package com.kaikai.leetcode.interviewTop100;



public class 矩阵置零73 {

    /**
     * 将二维矩阵中所有为0的元素设置为0，使用额外空间记录每行和每列是否有0。
     *
     * @param matrix 输入的二维矩阵，将在此矩阵上进行修改。
     */
    public static void setZeroes(int[][] matrix) {
        // 创建两个数组x和y，用于记录每行和每列是否有0
        int[] x = new int[matrix.length];
        int[] y = new int[matrix[0].length];

        // 遍历矩阵，若元素为0，则在对应的x和y数组中标记
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = 1;
                    y[j] = 1;
                }
            }
        }

        // 根据x和y数组的标记，将矩阵中相应的元素设置为0
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
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(ints[j]);
            }
        }
    }
}
