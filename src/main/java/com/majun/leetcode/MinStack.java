package com.majun.leetcode;

import java.util.*;

/**
 * @author majun 2021-11-27
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }


    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        Integer peek = stack.peek();
        stack.pop();

        if (Objects.equals(peek, min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return Optional.ofNullable(stack.peek()).orElse(0);
    }

    public int min() {
        return Optional.ofNullable(min.peek()).orElse(0);
    }
}