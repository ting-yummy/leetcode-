package com.jdt.leetcode.simple;

import org.springframework.util.StringUtils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author jdt
 * @date 2023/8/25
 */
public class Rewrite {
    public boolean isValid(String s) {
        if (StringUtils.isEmpty(s)) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        Deque<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!hashMap.containsKey(charArray[i])) {
                if (!stack.isEmpty() && stack.peek().equals(charArray[i])) {
                    stack.pop();
                }else{
                    return false;
                }
            } else {
                stack.push(hashMap.get(charArray[i]));
            }
        }
        return stack.isEmpty();
    }
}
