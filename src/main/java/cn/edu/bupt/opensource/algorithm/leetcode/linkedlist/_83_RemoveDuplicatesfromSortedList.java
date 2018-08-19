package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _83_RemoveDuplicatesfromSortedList</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 11:44</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 *      输入: 1->1->2
 *      输出: 1->2
 * 示例 2:
 *      输入: 1->1->2->3->3
 *      输出: 1->2->3
 *
 */
public class _83_RemoveDuplicatesfromSortedList {

    /**
     * time:O(n)
     * space:O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
