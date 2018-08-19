package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _92_ReverseLinkedListII</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 11:59</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明: 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 *      输入: 1->2->3->4->5->NULL, m = 2, n = 4
 *      输出: 1->4->3->2->5->NULL
 *
 */
public class _92_ReverseLinkedListII {

    /**
     * time:O(n)
     * space:O(1)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        // 寻找翻转起始位置
        for(int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        // 普通翻转
        for(int i = 0; i < n - m; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

}
