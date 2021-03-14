package com.jdt.leetcode.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0 
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        List<String> maxString = new ArrayList<>();
        List<String> temString = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String str = String.valueOf(chars[i]);
            if(temString.contains(str)) {
                if (temString.size() > maxString.size()) {
                    maxString = new ArrayList<>(temString);
                }
                int indexOfStr = temString.indexOf(str);
                for (int i2 = 0; i2 <= indexOfStr; i2++) {
                    temString.remove(0);
                }
            }
                temString.add(str);
        }
        if(temString.size()>=maxString.size()){
            maxString = temString;
        }
        System.out.println("maxString:"+maxString);
        return maxString.size();
    }

    public static void main(String[] args) {
        int size = lengthOfLongestSubstring("udf");
        System.out.println("size"+size);
    }
}

















