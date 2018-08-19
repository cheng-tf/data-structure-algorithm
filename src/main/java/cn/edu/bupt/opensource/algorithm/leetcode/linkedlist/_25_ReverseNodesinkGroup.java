package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;
/**
 * <p>Title: _25_ReverseNodesinkGroup</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 15:45</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例 :
 *      给定这个链表：1->2->3->4->5
 *      当 k = 2 时，应当返回: 2->1->4->3->5
 *      当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 *      你的算法只能使用常数的额外空间。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class _25_ReverseNodesinkGroup {

    /**
     * 递归
     * time:O(n)
     * space:O(n)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode cur = head;
        int count = 0;
        while(cur!= null && count != k) {
            cur =cur.next;
            count++;
        }
        if(count == k) {
            cur = reverseKGroup(cur, k);
            while(count-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;

            }
            head = cur;

        }
        return head;
    }

}
