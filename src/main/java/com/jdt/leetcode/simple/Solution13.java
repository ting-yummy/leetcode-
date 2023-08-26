package com.jdt.leetcode.simple;

import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 *
 * @author jdt
 * @date 2023/8/24
 */
public class Solution13 {


    /**
     * 判断当前和下一位的大小，如果比下一位小
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        char lastStr = '1';
        int num = 0;
        for (char ch : arr) {
            num += getValue(ch, lastStr);
            lastStr = ch;
        }
        return num;
    }

    private  int getValue(char ch, char lastStr) {
        int num = 0;
        switch (ch) {
            case 'M':
                if (lastStr == 'C') {
                    num += 900;
                    num -= 100;
                } else {
                    num += 1000;
                }
                break;
            case 'D':
                if (lastStr == 'C') {
                    num += 400;
                    num -= 100;
                } else {
                    num += 500;
                }
                break;
            case 'C':
                if (lastStr == 'X') {
                    num += 90;
                    num -= 10;
                } else {
                    num += 100;
                }
                break;
            case 'L':
                if (lastStr == 'X') {
                    num += 40;
                    num -= 10;
                } else {
                    num += 50;
                }
                break;
            case 'X':
                if (lastStr == 'I') {
                    num += 9;
                    num -= 1;
                } else {
                    num += 10;
                }
                break;
            case 'V':
                if (lastStr == 'I') {
                    num += 4;
                    num -= 1;
                } else {
                    num += 5;
                }
                break;
            case 'I':
                num += 1;
                break;
        }

        return num;
    }

    public int romanToInt2(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        hashMap.put("IV", 4);
        hashMap.put("IX", 9);
        hashMap.put("XL", 40);
        hashMap.put("XC", 90);
        hashMap.put("CD", 400);
        hashMap.put("CM", 900);

        if (s.length() == 1) {
            return hashMap.get(s);
        }
        char[] charArray = s.toCharArray();
        int num = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            StringBuilder nums = new StringBuilder().append(charArray[i]).append(charArray[i + 1]);
            if (hashMap.containsKey(nums.toString())) {
                num += hashMap.get(nums.toString());
                //特殊情况 倒数第二个和第三个如果合并，直接再加上最后一个即可
                if (i == charArray.length - 3) {
                    num += hashMap.get(String.valueOf(charArray[charArray.length - 1]));
                    return num;
                }
                i++;
            }
            //兼容 如果是倒数2个不能拼接，需要把最后一个值也计算一下
            else if (i == charArray.length - 2) {
                num += hashMap.get(String.valueOf(charArray[i]));
                num += hashMap.get(String.valueOf(charArray[i + 1]));
            } else {
                num += hashMap.get(String.valueOf(charArray[i]));
            }
        }
        return num;
    }
}
