package com.jdt.leetcode.Interview;

/**
 * 面试题 01.04. 回文排列
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview04 {
    public static boolean canPermutePalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        long highChar = 0L;
        long lowChar = 0L;
        for (int i = 0; i < charArray.length; i++) {
            char charAt = charArray[i];
            if (charAt > 64) {
                long move = 1L << (charAt - 64);
                //不为0就进行异或 去掉该字母
                if ((highChar & move) != 0) {
                    highChar ^= move;
                } else {
                    //为0就进行或，存储之前的数据和当前数据
                    highChar |= move;
                }
            } else {
                long move = 1 << charAt;
                //不为0就进行异或 去掉该字母
                if ((lowChar & move) != 0) {
                    lowChar ^= move;
                } else {
                    //为0就进行或，存储之前的数据和当前数据
                    lowChar |= move;
                }
            }

        }
        if (length % 2 == 0) {
            //偶数应该就什么都没存下来
            if (highChar != 0 || lowChar != 0) {
                return false;
            }
        } else {
            //奇数那么应该只能存下来一个比特位是奇数 存下来的那个值就是奇数
            //开始计算有几个比特位是1
            if (highChar != 0 && lowChar != 0) {
                return false;
            }
            if (highChar == 0 && lowChar == 0) {
                return false;
            }
            int count = 0;
            while (highChar != 0) {
                count += highChar & 1;
                highChar = highChar >> 1;
            }
            while (lowChar != 0) {
                count += lowChar & 1;
                lowChar = lowChar >> 1;
            }
            if (count != 1) {
                return false;
            }

        }

        return true;

    }

    public static boolean canPermutePalindrome2(String s) {
        //先判断字符串长度是奇数还是偶数
        //如果是偶数需要每个字符都是偶数
        //如果是奇数 只能一个字符是 奇数，其他的都得是偶数
        int length = s.length();
        int[] nums = new int[128];
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) % 128;
            if (nums[index] > 0) {
                nums[index]--;
            } else {
                nums[index]++;
            }
        }
        if (length % 2 == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    return false;
                }
            }
        } else {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    count++;
                }
            }
            if (count != 1) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        canPermutePalindrome("AaBb//a");
    }


}
