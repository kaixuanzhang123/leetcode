package com.kaikai.leetcode.bytedance;

public class 最长回文只串5 {

    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] flags = new boolean[length][length];
        for (int k = 0; k < length; k++) {
            flags[k][k] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int l = 1; l <= length - 1; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l;
                if (j < length) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i < 3) {
                            flags[i][j] = true;
                        } else {
                            flags[i][j] = flags[i + 1][j - 1];
                        }
                        if (flags[i][j] && j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            begin = i;
                        }
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }


}