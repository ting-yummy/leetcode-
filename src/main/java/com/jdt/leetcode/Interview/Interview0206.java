package com.jdt.leetcode.Interview;

import com.jdt.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview0206 {
    ListNode firstNode = null;

    public boolean isPalindrome(ListNode head) {
        firstNode = head;
        return check(head);

    }

    public boolean check(ListNode head) {
        if (head != null) {
            if (!check(head.next)) {
                return false;
            }
            if (head.val != firstNode.val) {
                return false;
            }
            firstNode = firstNode.next;
        }
        return true;

    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode pre = head;
        List<ListNode> list = new ArrayList<>();
        while (pre != null) {
            list.add(pre);
            pre = pre.next;
        }
        int size = list.size() / 2;
        for (int i = 0; i < size; i++) {
            if (list.get(i).val != list.get(list.size() - 1 - i).val) {
                return false;
            }
        }
        return true;

    }

    //1.双指针获取后半段，然后后半段进行反转和第一段比较是否一样
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        //获取后半段
        ListNode secondHalfNode = getSecondHalfNode(head);
        //反转
        ListNode reserveNode = getReserveNode(secondHalfNode);
        while (reserveNode != null) {
            if (reserveNode.val != head.val) {
                return false;
            }
            reserveNode = reserveNode.next;
            head = head.next;
        }
        return true;

    }

    private ListNode getReserveNode(ListNode secondHalfNode) {
        ListNode pre = null;
        ListNode currentNode = secondHalfNode;
        while (currentNode != null) {
            ListNode tempNode = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = tempNode;
        }
        return pre;
    }

    public ListNode getSecondHalfNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
