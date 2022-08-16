package com.kaikai.leetcode;

public class 岛屿数量200 {

    public static void dfs(String[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c].equals("0")) {
            return;
        }

        grid[r][c] = "0";
        int[][] nums={{0,1},{0,-1},{-1,0},{1,0}};
        for (int[] num : nums) {
            dfs(grid, r +num[0], c+num[1]);
        }
    }

    public static int numIslands(String[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c].equals("1")) {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }


    public static void main(String[] args) {
        String[][] board = {{"1", "1", "1", "1", "0"}, {"1", "1", "0", "1", "0"}, {"1", "1", "0", "0", "0"}, {"0", "0", "0", "0", "0"}};

        System.out.println(numIslands(board));
    }


}