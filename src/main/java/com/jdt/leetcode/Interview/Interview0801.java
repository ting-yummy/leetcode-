package com.jdt.leetcode.Interview;

/**
 * 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0801 {
    public int waysToStep(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int[] arar = new int[n + 1];
        arar[0] = 1;
        arar[1] = 1;
        arar[2] = 2;
        for (int i = 3; i <= n; i++) {
            arar[i] = ((arar[i - 1] + arar[i - 2]) % 1000000007 + arar[i - 3]) % 1000000007;
        }
        return arar[n];
    }
}
