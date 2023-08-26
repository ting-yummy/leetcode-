package com.jdt.leetcode.simple;

/**
 * 9. 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @author jdt
 * @date 2023/8/25
 */
public class Solution9 {

    public static boolean isPalindrome(int x) {
        //负数一定不是回文
        if (x < 0) {
            return false;
        }
        //数字就是0 本身就是回文
        if (x == 0) {
            return true;
        }
        //个位数为0的 只有0本身是回文
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int revertedNum = 0;
        while (revertedNum < x) {
            revertedNum = x % 10 + revertedNum * 10;
            x = x / 10;
        }
        return revertedNum ==x || x == revertedNum / 10;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        int length = charArray.length / 2;
        for (int i = 0; i < length; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }
}
