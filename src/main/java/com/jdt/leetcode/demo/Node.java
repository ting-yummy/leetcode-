package com.jdt.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdt
 * @date 2023/8/29
 */
public class Node {
    int val;
    char color;

    int weight;
    List<Node> nexts;

    public Node(int val, char color) {
        this.val = val;
        this.color = color;
        weight = 0;
        nexts = new ArrayList<>();
    }
}
