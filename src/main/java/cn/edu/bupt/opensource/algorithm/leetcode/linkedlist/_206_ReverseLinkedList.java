package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _206_ReverseLinkedList</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 12:57</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 反转一个单链表。
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 * 进阶:
 *      你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class _206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // 定义三个指针：pre、cur、tmp
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while(cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

}
