package com.jdt.leetcode.simple;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author jdt
 * @date 2023/8/24
 */
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String str1 = strs[0];
        int minSize = str1.length();
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int length = Math.min(minSize, str.length());
            minSize = length;
            for (int j = 0; j < length; j++) {
                if (str.charAt(j) != str1.charAt(j)) {
                    str1 = str1.substring(0, j);
                    minSize=Math.min(minSize,j);
                    break;
                }
            }

        }
        if (str1.length() > minSize) {
            str1 = str1.substring(0, minSize);
        }

        return str1;

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
