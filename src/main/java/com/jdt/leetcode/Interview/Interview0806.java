package com.jdt.leetcode.Interview;

import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        moveMethod(A.size(), A, B, C);

    }

    public void moveMethod(Integer num, List<Integer> orginList, List<Integer> helpList, List<Integer> taget) {
        if (num == 1) {
            taget.add(orginList.remove(orginList.size() - 1));
            return;
        }
        moveMethod(num - 1, orginList, taget, helpList);
        taget.add(orginList.remove(orginList.size() - 1));
        moveMethod(num - 1, helpList, orginList, taget);
    }
}
