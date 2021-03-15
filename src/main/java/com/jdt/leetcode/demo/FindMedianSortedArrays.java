package com.jdt.leetcode.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jdt
 * @date 2021/3/15 9:20
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 *  
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        //如果只有一个元素，那么就直接返回
        if (list.size() == 1) {
            return list.get(0);
        }
        //排序
        Collections.sort(list);
        //如果是偶数，集合从0开始 需要-1；如果是奇数获取中间的那个
        if (list.size() % 2 == 0) {
            int sumNum = list.get(list.size() / 2 - 1) + list.get(list.size() / 2);
            double result = sumNum / 2.0;
            return result;
        } else {
            return list.get((int) (list.size() / 2.0 - 0.5));
        }


    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,9,6};
        int[] nums2 = new int[]{4,8};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}