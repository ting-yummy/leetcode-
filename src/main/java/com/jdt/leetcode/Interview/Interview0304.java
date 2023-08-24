package com.jdt.leetcode.Interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.04. 化栈为队
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0304 {

    /**
     * 队列 先进先出
     * 栈 先进后出
     */
    Deque<Integer> pushStack;
    Deque<Integer> useStack;

    /**
     * Initialize your data structure here.
     */
    public Interview0304() {
        useStack = new ArrayDeque<>();
        pushStack = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!useStack.isEmpty()) {
            return useStack.pop();
        }
        while (!pushStack.isEmpty()) {
            useStack.push(pushStack.pop());
        }
        return useStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!useStack.isEmpty()) {
            return useStack.peek();
        }
        while (!pushStack.isEmpty()) {
            useStack.push(pushStack.pop());
        }
        return useStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return useStack.isEmpty() && pushStack.isEmpty();
    }
}
