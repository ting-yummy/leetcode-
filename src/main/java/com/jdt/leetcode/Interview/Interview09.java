package com.jdt.leetcode.Interview;

import org.springframework.util.StringUtils;

/**
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview09 {
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        //因为是轮转的，所以s1拼上s1一定会有一段是s2
        if ((s1 + s1).contains(s2)) {
            return true;
        }
        return false;
    }

    public static boolean isFlipedString2(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        //1.每次将s1的字符放到后面
        for (int i = 0; i < s1.length(); i++) {
            s1 = s1.substring(1) + s1.charAt(0);
            if (s1.equals(s2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
    }
}
