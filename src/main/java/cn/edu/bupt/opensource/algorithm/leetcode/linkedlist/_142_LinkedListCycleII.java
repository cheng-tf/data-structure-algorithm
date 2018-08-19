package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _142_LinkedListCycleII</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 12:37</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 环形链表II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 说明：不允许修改给定的链表。
 * 进阶：你是否可以不用额外空间解决此题？
 * Let the distance from the first node to the the node where cycle begins be A,
 * and let say the slow pointer travels travels A+B.
 * The fast pointer must travel 2A+2B to catch up.
 * The cycle size is N.
 * Full cycle is also how much more fast pointer has traveled than slow pointer at meeting point.
 *      A+B+N = 2A+2B
 *      N=A+B
 * From our calculation slow pointer traveled exactly full cycle when it meets fast pointer,
 * and since originally it travled A before starting on a cycle,
 * it must travel A to reach the point where cycle begins!
 * We can start another slow pointer at head node, and move both pointers until they meet at the beginning of a cycle.
 */
public class _142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        // #1 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                // #2 根据公式推导，环长为N=A+B；则slow指针距离第一个环形节点步长数为A，而slow2指针距离步长数也为A
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

}
