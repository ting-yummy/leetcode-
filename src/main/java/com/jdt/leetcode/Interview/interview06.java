package com.jdt.leetcode.Interview;

/**
 * @author jdt
 * @date 2023/8/20
 */
public class interview06 {

    //这两个写的方式差不多的，就是最后的判断拿到外面去了
    public static String compressString(String S) {
        int length = S.length();
        char[] charArray = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char charAt = ' ';
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            char charAt1 = charArray[i];
            //如果两个字符内容一样就增加数量
            if (charAt1 == charAt) {
                count++;
            } else {
                //这是为了兼容初始化的时候
                if (charAt != ' ') {
                    //如果不是初始化导致不一样的，遇到下一个字符如果与之前不一样那么重新进行统计
                    stringBuilder.append(charAt).append(count);
                }
                charAt = charAt1;
                count = 1;
            }
        }
        //如果当前是最后一个字符了，就需要将剩下的内容都拼接上去
        stringBuilder.append(charAt).append(count);

        return stringBuilder.length() >= length ? S : stringBuilder.toString();
    }

    public static String compressString2(String S) {
        int length = S.length();
        char[] charArray = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char charAt = ' ';
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            char charAt1 = charArray[i];
            //如果两个字符内容一样就增加数量
            if (charAt1 == charAt) {
                count++;
            } else {
                //这是为了兼容初始化的时候
                if (charAt != ' ') {
                    //如果不是初始化导致不一样的，遇到下一个字符如果与之前不一样那么重新进行统计
                    stringBuilder.append(charAt).append(count);
                }
                charAt = charAt1;
                count = 1;
            }
            //如果当前是最后一个字符了，就需要将剩下的内容都拼接上去
            if (i == charArray.length - 1) {
                stringBuilder.append(charAt).append(count);
            }
        }

        return stringBuilder.length() >= length ? S : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaa"));
        System.out.println(compressString("aa"));
        System.out.println(compressString("abbccd"));
    }
}
