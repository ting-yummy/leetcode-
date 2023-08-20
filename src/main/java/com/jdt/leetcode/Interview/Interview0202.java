package com.jdt.leetcode.Interview;

import com.jdt.leetcode.struct.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview0202 {

    /**
     * 双指针
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode fastNode = head;
        //先让快的指针往前先走k步，那么当快指针走到最后的时候，当前指针就是k值
        for (int i = 0; i < k; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            currentNode = currentNode.next;
            fastNode = fastNode.next;
        }
        return currentNode.val;
    }


    //进行倒序，然后查询第k个节点
    public int kthToLast2(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode pre = null;
        while (currentNode != null) {
            ListNode node = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = node;
        }
        int count = 1;
        while (count < k && pre != null) {
            pre = pre.next;
            count++;
        }

        return pre.val;
    }

}
