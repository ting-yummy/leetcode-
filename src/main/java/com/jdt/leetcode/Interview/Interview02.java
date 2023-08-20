package com.jdt.leetcode.Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview02 {

    /**
     * 由于字符串只包含 128种不同的字符，因此我们可以维护一个长度为 128的频次数组
     * 先遍历记录字符串 s1中字符出现的频次，
     * 然后遍历字符串 s2，减去table中对应的频次，如果出现 table[i]<0，则说明 s2 包含一个不在 s1中的额外字符，
     * 返回 false 即可
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/check-permutation-lcci/solutions/1395091/pan-ding-shi-fou-hu-wei-zi-fu-zhong-pai-dmkmc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] arrays = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            char charAt = s1.charAt(i);
            int i1 = charAt % 128;
            arrays[i1]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char charAt = s2.charAt(i);
            int i1 = charAt % 128;
            arrays[i1]--;
            if (arrays[i1] < 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * 先排序 再比较
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation1(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    /**
     * 两个字符串
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char charAt = s1.charAt(i);
            Integer count = map1.get(charAt);
            if (count == null) {
                map1.put(charAt, 1);
            } else {
                map1.put(charAt, count + 1);
            }
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char charAt = s2.charAt(i);
            if (!map1.containsKey(charAt)) {
                return false;
            }
            Integer count = map2.get(charAt);
            if (count == null) {
                map2.put(charAt, 1);
            } else {
                map2.put(charAt, count + 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map1.entrySet()) {
            if (!map2.get(characterIntegerEntry.getKey()).equals(characterIntegerEntry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation("abb", "aab");
    }
}
