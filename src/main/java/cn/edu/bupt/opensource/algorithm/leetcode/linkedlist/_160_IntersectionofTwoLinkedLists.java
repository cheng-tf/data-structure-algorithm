package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;
/**
 * <p>Title: _160_IntersectionofTwoLinkedLists</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 14:10</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 例如，下面的两个链表：
 *      A:          a1 → a2
 *                          ↘
 *                           c1 → c2 → c3
 *                          ↗
 *      B:     b1 → b2 → b3
 *      在节点 c1 开始相交。
 * 注意：
 *      如果两个链表没有交点，返回 null.
 *      在返回结果后，两个链表仍须保持原有的结构。
 *      可假定整个链表结构中没有循环。
 *      程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 */
public class _160_IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Y型链表
        // #1 计算两个链表的长度，较长者先步进lenMax-lenMin
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // #2 同时步进，寻找相交的第一个节点
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

}
