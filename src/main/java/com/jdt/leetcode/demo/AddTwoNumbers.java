package com.jdt.leetcode.demo;

import javax.xml.soap.Node;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1] 
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //根节点
       ListNode root = new ListNode(0);
       //游标
       ListNode cursor = root;
       //进位
       int carry=0;
       //当l1或者l2不为空。或者之前有进位，则需要进入循环中
       while(l1!=null||l2!=null||carry!=0){
           int l1Value = l1==null?0:l1.val;
           int l2Value = l2==null?0:l2.val;
           //总数相加
           int sum = l1Value+l2Value+carry;
           //超过10进位
           carry = sum/10;

           ListNode listNode = new ListNode(sum%10);
           //移动游标
           cursor.next=listNode;
           cursor=listNode;

           if(l1!=null){
               l1=l1.next;
           }
           if(l2!=null){
               l2=l2.next;
           }

       }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
