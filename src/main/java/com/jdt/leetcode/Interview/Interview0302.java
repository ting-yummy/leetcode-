package com.jdt.leetcode.Interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview0302 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public Interview0302() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
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

//
//    List<Integer> list;
//    List<Integer> minList;
//
//
//    /**
//     * initialize your data structure here.
//     */
//    public Interview0302() {
//        list = new ArrayList<>();
//        minList = new ArrayList<>();
//    }
//
//    public void push(int x) {
//        if (minList.size() == 0) {
//            minList.add(x);
//        } else {
//            int min = minList.get(minList.size() - 1);
//            if (min > x) {
//                minList.add(x);
//            } else {
//                minList.add(min);
//            }
//        }
//        list.add(x);
//    }
//
//    public void pop() {
//        if (list.size() == 0) {
//            return;
//        }
//        minList.remove(minList.size() - 1);
//        list.remove(list.size() - 1);
//    }
//
//    public int top() {
//        if (list.size() == 0) {
//            return -1;
//        }
//        return list.get(list.size() - 1);
//    }
//
//    public int getMin() {
//        if (minList.size() == 0) {
//            return -1;
//        }
//        return minList.get(minList.size() - 1);
//    }

}
