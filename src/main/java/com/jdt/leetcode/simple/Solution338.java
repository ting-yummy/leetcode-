package com.jdt.leetcode.simple;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 *
 * @author jdt
 * @date 2023/8/19
 */
public class Solution338 {

    /**
     * 方法一：Brian Kernighan 算法
     * <p>
     * 对于任意整数 x，令 x=x&(x−1)
     * 该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/counting-bits/solutions/627418/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = calCount(i);
        }
        return result;
    }

    private static int calCount(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

    /**
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
     * 举例：
     * 0 = 0       1 = 1
     * 2 = 10      3 = 11
     * <p>
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
     * 因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
     * 举例：
     * 2 = 10       4 = 100       8 = 1000
     * 3 = 11       6 = 110       12 = 1100
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        /**
         * 按照逻辑写完后
         */
//        for (int i = 2; i < result.length; i++) {
//            if (i % 2 == 0) {
//                result[i] = result[i >> 1];
//            } else {
//                result[i] = result[i - 2] + 1;
//            }
//        }

        /**
         * 优化后 发现奇数加1 偶数不加
         */
        for (int i = 1; i < result.length; i++) {
            //奇书&1 = 1 偶数&1=0
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : countBits(4)) {
            System.out.println(i);
        }
    }


}
