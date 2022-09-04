package com.kaikai.leetcode.baidu;

import com.sun.xml.internal.ws.util.exception.LocatableWebServiceException;
import jdk.nashorn.internal.ir.IfNode;

/**
 * Package: com.kaikai.leetcode.baidu
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/2 16:37
 * Modified By:
 */
public class 最长公共子序列1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] res = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[len1][len2];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
