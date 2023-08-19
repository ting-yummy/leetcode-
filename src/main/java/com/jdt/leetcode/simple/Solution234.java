package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * @author jdt
 * @date 2023/8/19
 */
public class Solution234 {

    /**
     * 方法三：
     * 使用快慢指针找到中间位置
     * 然后将后半段链标进行反转
     * 然后与前半段比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        //根据快慢指针拿到后半段数据
        ListNode needReverseNode = slowFastNode(head);
        //反转后半段数据
        ListNode reverseNode = reverse(needReverseNode);

        //比较链标前面内容和反转后的内容
        while (reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    private ListNode reverse(ListNode needReverseNode) {
        ListNode currentNode = needReverseNode;
        ListNode pre = null;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        return pre;

    }

    /**
     * 快慢指针，快指针走的速度是慢指针的2倍，因此快指针走完的时候 慢指针正好走到中间
     *
     * @param head
     * @return
     */
    private ListNode slowFastNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode.next;
    }


    private ListNode firstNode;

    /**
     * 方法二：递归
     * 如果使用递归反向迭代节点，同时使用递归函数外的变量向前迭代，就可以判断链表是否为回文。
     * <p>
     * 算法 currentNode 指针是先到尾节点，由于递归的特性再从后往前进行比较。
     * frontPointer 是递归函数外的指针。
     * 若 currentNode.val != frontPointer.val 则返回 false。
     * 反之，frontPointer 向前移动并返回 true。
     * <p>
     * 算法的正确性在于递归处理节点的顺序是相反的（回顾上面打印的算法），
     * 而我们在函数外又记录了一个变量，因此从本质上，我们同时在正向和逆向迭代匹配。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/palindrome-linked-list/solutions/457059/hui-wen-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        firstNode = head;
        return check(head);

    }

    public Boolean check(ListNode currentNode) {
        if (currentNode != null) {
            //进行递归到最后 开始往下走
            if (!check(currentNode.next)) {
                //比较节点后如果返回false 加上！==true 进入该判断 返回false 表示不是回文链标
                return false;
            }
            //从最后的开始和首节点比较 值不一样直接return
            if (currentNode.val != firstNode.val) {
                return false;
            }
            //把指向头节点的指针往后移动
            firstNode = firstNode.next;
        }
        return true;
    }

    /**
     * 方法一：数组
     * 使用数组把node值全部放入
     * 然后将数组分为两半
     * 头和尾进行比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> arrayList = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            arrayList.add(current.val);
            current = current.next;
        }
        int length = arrayList.size() / 2;
        for (int i = 0; i < length; i++) {
            if (!arrayList.get(i).equals(arrayList.get(arrayList.size() - 1 - i))) {
                return false;
            }
        }
        return true;

    }


}
