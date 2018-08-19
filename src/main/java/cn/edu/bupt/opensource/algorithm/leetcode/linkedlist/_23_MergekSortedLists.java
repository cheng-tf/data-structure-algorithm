package cn.edu.bupt.opensource.algorithm.leetcode.linkedlist;

/**
 * <p>Title: _23_MergekSortedLists</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 15:41</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 *  输入:
 *      [
 *          1->4->5,
 *          1->3->4,
 *          2->6
 *      ]
 *  输出: 1->1->2->3->4->4->5->6
 *
 */
public class _23_MergekSortedLists {


    /**
     * 推荐
     * 基于分治-递归思想
     * time:O(n·logk)
     * space:O(n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length-1);
    }

    private ListNode sort(ListNode[] lists, int low, int high) {
        if(low >= high) {
            return lists[low];
        }
        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid+1, high);
        return merge(l1, l2);
    }

    /**
     * 合并两个有序的链表（写法2：递归思想）
     * time:O(n)
     * space:O(n)
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

}
