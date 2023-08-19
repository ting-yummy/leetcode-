package com.jdt.leetcode.simple;

import org.springframework.util.StringUtils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author jdt
 * @date 2023/8/17
 */
public class Solution20 {
    public static boolean isValid(String s) {
        //首先一定是对称的
        int size = s.length();
        if (size % 2 != 0) {
            return false;
        }
        //有一个右括号就需要一个左括号，
        //左括号必须以正确的顺序闭合，所以正常是先遇到左括号放入栈中，遇到右括号时候，把左括号弹出，这样最后栈中是空的就符合要求
        //所以map的key为右括号，值为左括号
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            //包含右括号的时候需要弹出左括号
            if (map.containsKey(ch)) {
                //如果栈为空 或者第一个字符不是对应map的vlaue值 例如 第一个不是左括号那么肯定是不对的
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(isValid("{}(){}[]"));
//        System.out.println(isValid("{()}"));
//        System.out.println(isValid("{(})"));
        System.out.println(isValid("){"));
    }
}
