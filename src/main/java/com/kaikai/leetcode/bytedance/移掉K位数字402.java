package com.kaikai.leetcode.bytedance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Package: PACKAGE_NAME
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/7/27 14:56
 * Modified By:
 */
public class 移掉K位数字402 {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        stack.push(num.charAt(0));
        int j = 1;
        while (j < num.length()) {
            if (k > 0 && stack.size() > 0 && stack.peek() > num.charAt(j)) {
                stack.pop();
                k--;
            } else {
                stack.push(num.charAt(j));
                j++;
            }
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder strb = new StringBuilder();
        boolean flag = true;
        while (stack.size() > 0) {
            if (stack.peekLast() == '0' && flag && stack.size() != 1) {
                stack.pollLast();
            } else {
                flag = false;
                strb.append(stack.pollLast());
            }
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }
}
