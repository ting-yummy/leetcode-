package com.jdt.leetcode.Interview;

/**
 * 面试题 05.03. 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0503 {

    /**
     * curLen记录当前长度，
     *
     * preLen记录上次翻转后的长度，
     *
     * 因为只能翻转1次，所以需要再次翻转时curLen要减去preLen。
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        int currentCount = 0;
        int lastCount = 0;
        int maxLength = 0;
        int bits= 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                currentCount = currentCount - lastCount;
                lastCount = currentCount + 1;
            }
            currentCount++;
            maxLength = Math.max(maxLength, currentCount);
            num >>= 1;
        }

        return maxLength;

    }


    public int reverseBits3(int num) {
        int[] array = new int[32];
        int index = 0;
        while (num> 0) {
            if ((num & 1) == 0) {
               index++;
            }else{
                array[index]++;
            }
            num = num>>1;
        }
        int maxLength = 0;
        for (int i = 0; i < array.length-1; i++) {
            maxLength = Math.max(maxLength,array[i]+array[i+1]+1);
        }
        return maxLength;

    }
}
