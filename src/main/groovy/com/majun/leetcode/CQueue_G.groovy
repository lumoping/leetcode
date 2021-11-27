package com.majun.leetcode

class CQueue_G {
    Deque<Integer> stack
    Deque<Integer> reverseStack

    CQueue_G() {
        this.stack = new ArrayDeque<>()
        this.reverseStack = new ArrayDeque<>()
    }

    public void appendTail(int value) {
        stack.push(value)
    }

    public int deleteHead() {
        if (reverseStack.isEmpty() && stack.isEmpty()) {
            return -1
        }
        if (!reverseStack.isEmpty()) {
            return reverseStack.pop()
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Integer pop = stack.pop()
            reverseStack.push(pop)
        }
        return reverseStack.pop()
    }
}
