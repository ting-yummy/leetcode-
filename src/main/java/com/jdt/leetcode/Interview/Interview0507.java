package com.jdt.leetcode.Interview;

/**
 * 面试题 05.07. 配对交换
 * <p>
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 示例2:
 * <p>
 * 输入：num = 3
 * 输出：3
 * 提示:
 * <p>
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0507 {
    public int exchangeBits(int num) {
        //奇数
        //ox55555555 = 0101 0101 0101 0101 0101 0101 0101 0101
        int odd = num & 0x55555555;
        //偶数
        //0xaaaaaaaa = 1010 1010 1010 1010 1010 1010 1010 1010
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >> 1;
        return odd|even;
    }

}
