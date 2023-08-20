package com.jdt.leetcode.simple;

/**
 * 461. 汉明距离
 * <p>
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x, y <= 231 - 1
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Solution461 {

    /**
     * Brian Kernighan 算法
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        //^ 二进制位上不一样的话才会为1 ，那么diff出来的1的位置即两者不同的地方
        int diff = x ^ y;
        int count = 0;
        //diff&（diff-1） 循环几次可以获取有几个1
        while (diff > 0) {
            diff = diff & (diff - 1);
            count++;
        }
        return count;
    }

    /**
     * 先进行异或计算 算出来的值即相差的1的数
     * <p>
     * 将该数&1 判断最低位的值是1还是0，如果是1进行计数
     * 然后将该数右移再次循环计算，最后计数值即含有1的个数
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        int diff = x ^ y;
        int count = 0;
        while (diff > 0) {
            int moveNum = diff & 1;
            if (moveNum > 0) {
                count++;
            }
            diff = diff >> 1;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance2(1, 4));

    }
}
