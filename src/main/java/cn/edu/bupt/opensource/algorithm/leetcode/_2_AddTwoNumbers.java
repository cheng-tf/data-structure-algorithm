package cn.edu.bupt.opensource.algorithm.leetcode;

/**
 * <p>Title: _2_AddTwoNumbers</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-17 11:00</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 465 = 807
 * time:O(n)
 * space:O(n)
 */
public class _2_AddTwoNumbers {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;
        while(p1 != null || p2 != null) {
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum = sum / 10;
            cur = cur.next;
        }
        if(sum == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
