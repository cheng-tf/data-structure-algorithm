package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _61_RotateList</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 16:02</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 *      输入: 1->2->3->4->5->NULL, k = 2
 *      输出: 4->5->1->2->3->NULL
 * 解释:
 *      向右旋转 1 步: 5->1->2->3->4->NULL
 *      向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *      输入: 0->1->2->NULL, k = 4
 *      输出: 2->0->1->NULL
 * 解释:
 *      向右旋转 1 步: 2->0->1->NULL
 *      向右旋转 2 步: 1->2->0->NULL
 *      向右旋转 3 步: 0->1->2->NULL
 *      向右旋转 4 步: 2->0->1->NULL
 *
 */
public class _61_RotateList {

    /**
     * 单指针
     * time:O(n)
     * space:O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        // 计算链表长度
        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            len++;
            cur = cur.next;
        }
        // head指针向后移动len - k%len步
        cur.next = head;
        for(int i = 1; i < len - k%len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    /**
     * 双指针
     * time:O(n)
     * space:O(n)
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 计算链表长度，并求出实际移动数j
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        int j = k % len;
        // 定义两个指针，first指针先移动j步，然后两个指针同时移动直至链表末尾
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0; i < j; i++) {
            first = first.next;
        }
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        dummy.next = second.next;
        second.next = null;
        return dummy.next;

    }

}
