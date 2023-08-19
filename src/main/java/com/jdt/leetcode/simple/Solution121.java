package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * @author jdt
 * @date 2023/8/17
 */
public class Solution121 {

    public static int maxProfit(int[] prices) {
        int diff = 0;
        int smallValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (smallValue > prices[i]) {
                smallValue = prices[i];
            } else if (prices[i] - smallValue > diff) {
                diff = prices[i] - smallValue;
            }
        }
        return diff;
    }

    public static int cal(TreeNode node, int diff) {
        if (node == null) {
            return diff;
        }
        if (node.right == null) {
            return diff;
        }
        int diff2 = node.right.val - node.val;
        diff = diff2 > diff ? diff2 : diff;
        int cal = cal(node.left, diff);
        int cal1 = cal(node.right, diff);
        return cal > cal1 ? cal : cal1;
    }


    //暴力解法 数组长不合适啊
    public static int maxProfit1(int[] prices) {
        int diff = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diffMoney = prices[j] - prices[i];
                diff = diffMoney > diff ? diffMoney : diff;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7, 7, 5, 3, 9, 1,4});
        System.out.println(i);
        int j = maxProfit1(new int[]{7, 7, 5, 3, 9, 1,4});
        System.out.println(j);
    }
}
