package com.majun.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//测试gitcheck
/**
 * @author majun 2021-11-27
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
class CQueue {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> reverseStack = new ArrayDeque<>();


    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (reverseStack.isEmpty() && stack.isEmpty()) {
            return -1;
        }
        if (!reverseStack.isEmpty()) {
            return reverseStack.pop();
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Integer pop = stack.pop();
            reverseStack.push(pop);
        }
        return reverseStack.pop();
    }
}