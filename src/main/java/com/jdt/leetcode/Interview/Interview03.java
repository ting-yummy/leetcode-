package com.jdt.leetcode.Interview;

/**
 * 面试题 01.03. URL化
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 字符串长度在 [0, 500000] 范围内。
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview03 {
    public static String replaceSpaces(String S, int length) {
        char[] charArray = S.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }


    /**
     * 假定该字符串尾部有足够的空间存放新增字符
     * 所以可以从后往前放
     * 举例：ABC AB      ｜ 假设长度位11，实际长度是7
     *    ｜ ABC%20AB%20｜
     * @param S
     * @param length
     * @return
     */
    public static String replaceSpaces2(String S, int length) {

        char[] charArray = S.toCharArray();
        int index = charArray.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                charArray[index--] = '0';
                charArray[index--] = '2';
                charArray[index--] = '%';
            } else {
                charArray[index--] = charArray[i];
            }
        }
        return new String(charArray, index + 1, charArray.length - index - 1);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("     ", 5));
    }
}
