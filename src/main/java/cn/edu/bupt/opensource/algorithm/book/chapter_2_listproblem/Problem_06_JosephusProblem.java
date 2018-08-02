package cn.edu.bupt.opensource.algorithm.book.chapter_2_listproblem;

/**
 * 题目：环形单链表的约瑟夫问题
 * 要求：给定一个长度为N的环形单链表的头节点head和报数值m，返回最后生存下来的点，且此节点自己组成环形单链表。时间复杂度为O(N)
 * 提示：
 * 	1 普通解法：每删除一个节点则遍历m次，时间复杂度为O(N*m)
 * 	2 进阶解法：
 * 		1 实质是直接确定最后存活的节点
 * 		2 首先分析得到报数（A）和编号节点（B）的关系为：B=(A-1)%i+1，其中i为环中节点数
 * 		3 再分析得到：old=(new+m-1)%i+1，其中old为环大小为i时的节点编号，new为环大小为i-1时的节点编号。
 * 		4 使用递归过程来确定存活节点，其中Num(1)=1。
 * @author john
 *
 */
public class Problem_06_JosephusProblem {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node josephusKill1(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node last = head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if (++count == m) {
				last.next = head.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

	public static Node josephusKill2(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1;			// tmp -> list size
		while (cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m);	// tmp ->survive node position	
		while (--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	public static int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
	}

	public static void printCircularList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print("Circular List: " + head.value + " ");
		Node cur = head.next;
		while (cur != head) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println("-> " + head.value);
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = head1;
		printCircularList(head1);
		head1 = josephusKill1(head1, 3);
		printCircularList(head1);

		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);
		head2.next.next.next.next.next = head2;
		printCircularList(head2);
		head2 = josephusKill2(head2, 3);
		printCircularList(head2);

	}

}