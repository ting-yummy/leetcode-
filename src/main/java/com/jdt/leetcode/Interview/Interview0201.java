package com.jdt.leetcode.Interview;

import com.jdt.leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * @author jdt
 * @date 2023/8/20
 */
public class Interview0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null){
            return null;
        }
        Set<Integer> node = new HashSet<>();
        node.add(head.val);
        ListNode pre = head;
        while (pre.next != null) {
            if (node.add(pre.next.val)) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        pre.next = null;
        return head;

    }

}