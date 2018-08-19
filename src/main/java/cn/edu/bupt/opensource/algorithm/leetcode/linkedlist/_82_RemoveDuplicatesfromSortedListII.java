package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _82_RemoveDuplicatesfromSortedListII</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 16:27</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现的数字。
 * 示例 1:
 *      输入: 1->2->3->3->4->4->5
 *      输出: 1->2->5
 * 示例 2:
 *      输入: 1->1->1->2->3
 *      输出: 2->3
 *
 */
public class _82_RemoveDuplicatesfromSortedListII {

    /**
     * time:O(n)
     * space:O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null) {
            // 若存在重复数字节点，则获取数字，并循环删除
            if(p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while(p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

}
