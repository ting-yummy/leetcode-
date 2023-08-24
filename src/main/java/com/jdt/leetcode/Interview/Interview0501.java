package com.jdt.leetcode.Interview;

/**
 * 面试题 05.01. 插入
 * <p>
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * <p>
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 * <p>
 * <p>
 * <p>
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * 输出：N = 1100(10001001100)
 * 示例2:
 * <p>
 * 输入： N = 0, M = 31(11111), i = 0, j = 4
 * 输出：N = 31(11111)
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0501 {
    public static int insertBits(int N, int M, int i, int j) {
        //获取N最高位，j以后为0填充 因为i和j统计从0开始的！！！所以移动位数需要多1位
        int high1 = N >> j >> 1;
        int high = high1 << j << 1;
        //获取N最低位 1往右移动i位即2^n次方，减1也就是是i位之后全是1，i位以前是0，那么低位和该数值与运算保留低位值
        int low = N & ((1 << i) - 1);

        int newMiddle = M << i;
        return high | newMiddle | low;
    }

    public static void main(String[] args) {
        System.out.println(insertBits(2032243561, 10, 24, 29));
    }
}
