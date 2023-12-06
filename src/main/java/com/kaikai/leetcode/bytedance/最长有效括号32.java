package com.kaikai.leetcode.bytedance;

import java.util.Deque;
import java.util.LinkedList;

public class 最长有效括号32 {

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    max = Math.max(i - stack.peek() , max);
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }


}