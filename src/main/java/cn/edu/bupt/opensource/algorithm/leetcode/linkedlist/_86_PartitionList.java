package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _86_PartitionList</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 11:51</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 *      输入: head = 1->4->3->2->5->2, x = 3
 *      输出: 1->2->2->4->3->5
 *
 */
public class _86_PartitionList {

    /**
     * time:O(n)
     * space:O(n)
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        // 定义2个链表，遍历原链表依次构建，然后结合即可
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode big = bigHead;
        while(head != null) {
            ListNode tmp = new ListNode(head.val);
            if(head.val < x) {
                small.next = tmp;
                small = small.next;
            } else {
                big.next = tmp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }

}
