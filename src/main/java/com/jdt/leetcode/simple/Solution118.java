package com.jdt.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 *
 * @author jdt
 * @date 2023/8/30
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(numRows);
            for (int j = 0; j < numRows; j++) {
                if (i == j || j == 0) {
                    row.add(1);
                } else {
                    int num = resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j);
                    row.add(num);
                }
            }
            resultList.add(row);
        }
        return resultList;
    }

    public static int[][] generate2(int numRows) {
        int[][] array = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0||i==0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] ints = generate2(5);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
