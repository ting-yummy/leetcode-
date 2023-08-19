package com.jdt.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 * <p>
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * <p>
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 *
 * @author jdt
 * @date 2023/8/17
 */
public class Solution136 {

    /**
     * 答案是使用位运算。对于这道题，可使用异或运算^。异或运算有以下三个性质。
     * <p>
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a^0=a
     * 任何数和其自身做异或运算，结果是 0，即 a^a=0
     * 异或运算满足交换律和结合律，即 a^b^a=b^a^a=b^(a^a)=b^0=b
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], value + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
