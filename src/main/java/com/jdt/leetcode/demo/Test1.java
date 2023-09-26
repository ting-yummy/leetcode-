package com.jdt.leetcode.demo;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://mp.weixin.qq.com/s/-_ALl1I9EIKAfR8gTvIovw
 * 1.有一颗有根树 根节点为1号节点 每个节点为红色或蓝色 假设第i个节点的权值为从根节点到该节点红蓝节点的数量之差 请你返回所有节点的权值之和
 * 输入
 * 第一行输入n个节点 第二行为每个节点的颜色 接下来n-1行为a b节点之间有一条线
 * 5
 * RBBRB
 * 1 5
 * 2 5
 * 1 3
 * 5 4
 * 输出
 * 3
 * <p>
 * <p>
 * <p>
 * 作者：大菠萝_pineapple
 * 链接：https://www.nowcoder.com/interview/center?entranceType=%E5%AF%BC%E8%88%AA%E6%A0%8F
 * 来源：牛客网
 *
 * @author jdt
 * @date 2023/8/29
 */
public class Test1 {

    public static void main(String[] args) {
        //第一行输入n个节点 第二行为每个节点的颜色 接下来n-1行为a b节点之间有一条线
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String colors = in.next();
        char[] charArray = colors.toCharArray();
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (!nodes.containsKey(u)) {
                nodes.put(u, new Node(u, charArray[u - 1]));
            }
            if (!nodes.containsKey(v)) {
                nodes.put(v, new Node(v, charArray[v - 1]));
            }
            Node from = nodes.get(u);
            Node to = nodes.get(v);
            from.nexts.add(to);
            to.nexts.add(from);//互相添加成为另据
        }

        System.out.println(cal(nodes));


    }

    public static int cal(HashMap<Integer, Node> nodes) {
        Node rootNode = nodes.get(1);
        rootNode.weight = rootNode.color == 'R' ? 1 : -1;

        HashSet set = new HashSet();
        set.add(rootNode);
        LinkedList<Node> list = new LinkedList();
        list.add(rootNode);

        int ans = 0;
        while (!list.isEmpty()) {
            Node cur = list.poll();
            ans += Math.abs(cur.weight);

            for (Node next : cur.nexts) {

                next.weight = cur.weight + (next.color == 'R' ? 1 : -1);

                if (!set.contains(next)) {
                    set.add(next);
                    list.add(next);
                }
            }
        }
        return ans;
    }
}
