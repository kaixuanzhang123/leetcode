package com.kaikai.leetcode.bytedance;

public class 单词搜索 {

    public static boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean check = check(board, visit, i, j, word, 0);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                boolean check = check(board, visited, x, y, s, k + 1);
                if (check) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return res;
    }


    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};

        System.out.println(exist(board, "AAB"));
    }


//    ListNode listNode6 = new ListNode(6);
//    ListNode listNode3 = new ListNode(3, listNode6);
//    ListNode listNode4 = new ListNode(4, listNode3);
//    ListNode listNode5 = new ListNode(5, listNode4);
//    ListNode listNode2 = new ListNode(2, listNode5);
//    ListNode listNode7 = new ListNode(7, listNode2);
//    ListNode listNode9 = new ListNode(9, listNode7);

//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
}