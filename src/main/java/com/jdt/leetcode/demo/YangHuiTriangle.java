package com.jdt.leetcode.demo;

/**
 * 杨辉三角
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 。。。。。。。
 *
 * @author jdt
 * @date 2023/8/30
 */
public class YangHuiTriangle {
    /**
     * 思路
     * f(x,y) = f(x-1,y-1)+f(x-1,y), 当y=0或者x=y的时候值=1
     * 所以可以用递归来写
     */
    public static int YangHui(int x, int y) {
        int[][] array = new int[x][x];

        recursion(array, x - 1, y - 1);
        return array[x - 1][y - 1];
    }


    public static void recursion(int[][] array, int x, int y) {
        if (x == y || y == 0) {
            array[x][y] = 1;
            return;
        }
        recursion(array, x - 1, y - 1);
        recursion(array, x - 1, y);
        array[x][y] = array[x - 1][y - 1] + array[x - 1][y];
    }

    public static void main(String[] args) {
        System.out.println(YangHui(2, 1));
//        for (int i = 0; i < ints.length; i++) {
//            for (int j = 0; j < ints[i].length; j++) {
//                System.out.println(ints[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
