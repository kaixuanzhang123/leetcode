package com.kaikai.leetcode;

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
public class 最小栈155 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public 最小栈155() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        xStack.push(val);
        if (minStack.size() == 0) {
            minStack.push(val);
        } else {
            int peek = minStack.peek();
            minStack.push(Math.min(peek, val));
        }
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
