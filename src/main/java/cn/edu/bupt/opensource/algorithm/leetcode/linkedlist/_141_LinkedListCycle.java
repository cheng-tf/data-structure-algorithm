package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _141_LinkedListCycle</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 12:24</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 进阶：
 *      你能否不使用额外空间解决此题？
 *
 */
public class _141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        // 定义快慢指针，若存在环，则一定会出现两个指针相等的情况
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

}
