package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

import java.util.Stack;

/**
 * <p>Title: _234_PalindromeLinkedList</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 13:34</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 *      输入: 1->2
 *      输出: false
 * 示例 2:
 *      输入: 1->2->2->1
 *      输出: true
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class _234_PalindromeLinkedList {

    /**
     * 不基于任何数据结构
     * time:O(n)
     * space:O(1)
     */
    public boolean isPalindrome(ListNode head) {
        // #1 基于快慢指针，寻找链表右半区
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        // #2 翻转链表右半区
        slow = reverse(slow);
        // #3 左右半区同时向中间遍历，若存在不等值，则返回false
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    /**
     * 栈-仅需将链表右半区放入栈即可，再弹出比较
     * time:O(n)
     * space:O(n)
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        // #1 基于快慢指针，寻找链表右半区
        ListNode cur = head;
        ListNode right = head.next;
        while(cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            right = right.next;
        }
        // #2 将链表右半区放入栈
        Stack<ListNode> stack = new Stack<>();
        while(right != null) {
            stack.push(right);
            right = right.next;
        }
        // #3 出栈与左半区判断，若存在不等值则返回false
        while(!stack.isEmpty()) {
            if(head.val != stack.pop().val) {
                return false;
            }
            head =head.next;
        }
        return true;
    }

}
