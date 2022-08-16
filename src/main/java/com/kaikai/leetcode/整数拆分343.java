package com.kaikai.leetcode;

public class 整数拆分343 {

    public static int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0)
            return (int) Math.pow(3, a);
        if (b == 1)
            return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int curMax = 0;
            for (int j = 0; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }


}