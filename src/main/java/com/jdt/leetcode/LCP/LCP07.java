package com.jdt.leetcode.LCP;

import java.util.ArrayList;
import java.util.List;

/**
 * LCP 07. 传递信息
 * <p>
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * <p>
 * 输出：0
 * <p>
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 * @author jdt
 * @date 2023/8/25
 */
public class LCP07 {

    /**
     * 前两种方法都是通过在图中搜索计算方案数。可以换一个思路，这道题是计数问题，可以使用动态规划的方法解决。
     *
     * 定义动态规划的状态 dp[i][j]为经过 i 轮传递到编号 j 的玩家的方案数，其中 0≤i≤k，0≤j<n
     *
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/chuan-di-xin-xi/solutions/212912/chuan-di-xin-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public static int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1; //从0走到0
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    //存储0-（n-1）下标个数组，里面每一个下标对应一个数组存放的是自己可以传递的下标
    List<List<Integer>> edges;
    int n;
    int result = 0;
    int k;

    public int numWays2(int n, int[][] relation, int k) {
        //初始化
        this.n = n;
        this.k = k;
        edges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        //遍历二维数组，将第一个下标为数组下标，第二个为该下标内的元素
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        //计算深度
        dfs(0, 0);
        return result;

    }

    private void dfs(int index, int steps) {
        //路径已经到k步了 无论满不满足条件都结束
        if (steps == k) {
            //满足条件则记录一次数据
            if (index == n - 1) {
                result++;
            }
            return;
        }
        //获取下一个下标为x数组的数据
        List<Integer> list = edges.get(index);
        for (Integer nextIndex : list) {
            dfs(nextIndex, steps);
        }

    }

    public static void main(String[] args) {
        int[][] relation = new int[][]{
                {0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}
        };
        numWays(5, relation, 3);
    }
}
