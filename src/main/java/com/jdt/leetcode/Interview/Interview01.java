package com.jdt.leetcode.Interview;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview01 {

    /**
     * 标准ASCII 码也叫标准ASCII（基础ASCII码），标准ASCII码用一个字节（8位）表示一个字符，并规定其最高位为0，实际只用到7位，码值为00000000~01111111，即 0~127。因此可表示 128 个不同字符 。
     * 标准 ASCII 码包括数字 0~9、 26 个大写英文字母、 26 个小写英文字母，以及各种标点符号、运算符号和控制命令符号等
     * 一共128位 所以可以用2个long类型进行判断
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        int length = astr.length();
        long highBit = 0;
        long lowBit = 0;
        for (int i = 0; i < length; i++) {
            char charAt = astr.charAt(i);
            if (length > 64) {
                long move = 1 << (charAt - 64);
                if ((highBit & move) != 0) {
                    return false;
                }
                highBit |= move;
            } else {
                long move = 1 << charAt;
                if ((lowBit & move) != 0) {
                    return false;
                }
                lowBit |= move;
            }
        }
        return true;

    }

    /**
     * A-Z 65-90
     * a-z 97-122
     * 所以A-z大小为122-65+1=58位，如果该题目会出现大小写则需要用Long类型64位
     * 由于本题值出现小写也就是 26字母 可以用int类型
     *
     * @param astr
     * @return
     */
    public boolean isUnique1(String astr) {
        int length = astr.length();
        //由于都是小写字母，最多26个不重复，超过肯定重复了
        if (length > 26) {
            return false;
        }
        int bit = 0;
        for (int i = 0; i < length; i++) {
            char charAt = astr.charAt(i);
            int count = charAt - 'a';// 计算出来的值应该是0-25
            int move = 1 << count;
            if ((bit & move) != 0) {
                return false;
            }
            bit = bit | move;
        }
        return true;
    }

    /**
     * 遍历字符串，获取字符 判断出现在字符串的第一个下标位置和最后一样是否一样，不一样说明重复
     *
     * @param astr
     * @return
     */
    public boolean isUnique2(String astr) {
        int length = astr.length();
        for (int i = 0; i < length; i++) {
            //获取字符串第一个字符
            char charAt = astr.charAt(i);
            if (astr.indexOf(charAt) != astr.lastIndexOf(charAt)) {
                return false;
            }
        }
        return true;

    }
}
