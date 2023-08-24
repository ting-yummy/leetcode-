package com.jdt.leetcode.Interview;

import java.awt.*;

/**
 * 面试题 08.10. 颜色填充
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * <p>
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * <p>
 * <p>
 * 提示：
 * <p>
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 *
 * @author jdt
 * @date 2023/8/24
 */
public class Interview0810 {
    /**
     * 翻译一下题目 一开始看不懂
     * <p>
     * 1 👈 1 👉 1
     * 👇   👆
     * 1 👈 1    0
     * 👇
     * 1    0    1
     * ==============
     * 2    2    2
     * <p>
     * 2    2    0
     * <p>
     * 2    0    1
     */
    int row;
    int col;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //先获取该值 然后搜索他上下左右的数字
        int num = image[sr][sc];
        row = image.length;
        col = image[0].length;
        boolean[][] markSearch = new boolean[row][col];
        search(num, image, sr, sc, newColor, markSearch);
        return image;


    }

    private void search(int num, int[][] image, int sr, int sc, int newColor, boolean[][] markSearch) {
        //越界判断
        if (sr > row - 1 || sc > col - 1 || sr < 0 || sc < 0) {
            return;
        }
        //标记过了直接返回
        if (markSearch[sr][sc]) {
            return;
        }
        // 查询过的点需要标标记
        markSearch[sr][sc] = true;
        int imageNum = image[sr][sc];
        // 不相等结束
        if (imageNum != num) {
            return;
        }
        image[sr][sc] = newColor;
        //设置该点的四个方向进行递归
        search(num, image, sr, sc + 1, newColor, markSearch);
        search(num, image, sr + 1, sc, newColor, markSearch);
        search(num, image, sr, sc - 1, newColor, markSearch);
        search(num, image, sr - 1, sc, newColor, markSearch);
    }

}
