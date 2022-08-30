package com.kaikai.leetcode.interviewTop100;

import java.beans.beancontext.BeanContext;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/8/30 17:16
 * Modified By:
 */
public class 实现strStr28 {
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        int start = -1;
        for (int i = 0; i + len2 <= len1; i++) {
            boolean flag = true;
            for (int j = 0; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                start = i;
                break;
            }
        }
        return start;

    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
