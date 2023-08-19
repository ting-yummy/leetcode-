package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.ListNode;

import java.util.List;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * @author jdt
 * @date 2023/8/18
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode preNode =null;
        ListNode currentNode = head;
        while(currentNode!=null){
            //临时找一个节点存放当前的下一个node
            ListNode node = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = node;
        }
        return preNode;
    }



    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverseNode = new ListNode(head.val);
        return match(head.next, reverseNode);
    }

    public ListNode match(ListNode node, ListNode reverseNode) {
        if (node == null) {
            return reverseNode;
        }
        reverseNode = new ListNode(node.val, reverseNode);
        return match(node.next, reverseNode);
    }
}
