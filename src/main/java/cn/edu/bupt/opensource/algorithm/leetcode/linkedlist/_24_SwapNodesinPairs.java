package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _24_SwapNodesinPairs</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 15:43</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 示例:
 *      给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 *      你的算法只能使用常数的额外空间。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class _24_SwapNodesinPairs {

    /**
     * time:O(n)
     * space:O(1)
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node1 = dummy;
        ListNode node2 = head;
        while(node2 != null && node2.next != null) {
            ListNode nextStart = node2.next.next;
            node1.next = node2.next;
            node2.next.next = node2;
            node2.next = nextStart;
            node1 = node2;
            node2 = node2.next;
        }
        return dummy.next;
    }

}
