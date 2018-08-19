package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _203_RemoveLinkedListElements</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 14:02</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 *      输入: 1->2->6->3->4->5->6, val = 6
 *      输出: 1->2->3->4->5
 *
 */
public class _203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        // 定义一个pre指针，滞后head指针1个步长
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null) {
            if(head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre =pre.next;
                head = head.next;
            }
        }
        return dummy.next;
    }

}
