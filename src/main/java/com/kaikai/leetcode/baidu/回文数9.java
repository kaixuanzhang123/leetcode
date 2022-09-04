package com.kaikai.leetcode.baidu;

/**
 * Package: com.kaikai.leetcode.baidu
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/4 13:21
 * Modified By:
 */
public class 回文数9 {
    //反转一半进行比价的思路要好好体会

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return x == res || x == res / 10;
    }
}
