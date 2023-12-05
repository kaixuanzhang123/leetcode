package com.kaikai.leetcode.interviewTop100;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/29 21:01
 * Modified By:
 */
public class 最长公共前缀14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String start = strs[0];
        for (int i = 1; i < strs.length; i++) {
            start = longestCommonPrefix(start, strs[i]);
        }
        return start;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        int lengh = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < lengh) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            i++;
        }
        return str1.substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
