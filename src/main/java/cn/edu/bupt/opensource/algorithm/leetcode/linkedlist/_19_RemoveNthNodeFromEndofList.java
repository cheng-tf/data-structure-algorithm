package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _19_RemoveNthNodeFromEndofList</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 15:36</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：给定的 n 保证是有效的。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 */
public class _19_RemoveNthNodeFromEndofList {

    /**
     * time:O(n)
     * space:O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        ListNode second = dummy;
        dummy.next = head;
        // 先移动first指针，与second指针之间保持n个节点
        for(int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        // 继续移动first指针结束，同时注意保持间隔
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
