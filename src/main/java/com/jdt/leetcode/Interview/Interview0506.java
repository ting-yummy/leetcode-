package com.jdt.leetcode.Interview;

/**
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0506 {
    public int convertInteger(int A, int B) {
        int cal = A ^ B;
        int count = 0;
        while (cal != 0) {
            cal = cal & (cal - 1);
            count++;
        }

        return count;
    }
}
