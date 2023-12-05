package com.kaikai.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Package: com.kaikai.leetcode
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/2 0:24
 * Modified By:
 */
public class 最小栈155不使用辅助栈 {
    private Deque<int[]> stack;

    public 最小栈155不使用辅助栈() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if(stack.isEmpty() ){
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, Math.min(val,getMin())});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
