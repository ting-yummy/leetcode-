package com.jdt.leetcode.Interview;

/**
 * 面试题 03.01. 三合一
 * 提示
 * 简单
 * 70
 * 相关企业
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= stackNum <= 2
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview0301 {
    int[][] array;

    public Interview0301(int stackSize) {
        array = new int[3][stackSize + 1];//+1是为了固定int[][0]这个位置存放当前对象占用了多少长度
    }

    public void push(int stackNum, int value) {
        //获取当前已经存放了多少长度
        int currenIndex = array[stackNum][0];
        //如果存放的长度已经等于（数组长度-1）还有一个是自己
        if (currenIndex < array[stackNum].length - 1) {
            array[stackNum][currenIndex + 1] = value;
            array[stackNum][0]++;

        }
    }

    public int pop(int stackNum) {
        int currenIndex = array[stackNum][0];
        if (currenIndex <= 0) {
            return -1;
        }
        int i = array[stackNum][currenIndex];
        array[stackNum][0]--;
        return i;
    }

    public int peek(int stackNum) {
        int currenIndex = array[stackNum][0];
        if (currenIndex <= 0) {
            return -1;
        }
        int i = array[stackNum][currenIndex];
        return i;
    }

    public boolean isEmpty(int stackNum) {
        return array[stackNum][0] == 0;
    }
}
