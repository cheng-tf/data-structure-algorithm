package cn.edu.bupt.opensource.algorithm.book.chapter_2_listproblem;

import java.util.Stack;

/**
 * 题目：两个单链表生成相加链表
 * 例如：链表1为9->3->7，链表2为6->3，则新链表为1->0->0->0。
 * 要求：若链表长度为N，要求时间复杂度为O(N)，且不使用额外的数据结构，只用有限个变量。
 * 提示：
 * 	1 普通解法：空间复杂度为O(N)
 * 		1 使用栈结构，遍历两个链表，依次压入两个栈中，从而生成两个逆序栈s1、s2；
 * 		2 s1和s2同步弹出，并生成相加链表，同时需要关注每一步是否有进位ca；
 * 		3 当s1和s2为空时，若进位信息ca为1，则生成节点值以为1的新节点；
 * 		4 返回结果链表即可。
 * 	2 进阶解法：
 * 		1 将两个链表逆序，则可以一次得到从低位到高位的数字；
 * 		2 同步遍历，生成相加链表，同时需要关注进位信息；当遍历完后，同样需要关注进位信息；
 * 		3 再次逆序两链表，返回结果链表即可。
 * @author john
 *
 */
public class Problem_10_AddTwoLinkedLists {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node addLists1(Node head1, Node head2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		while (head1 != null) {
			stack1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			stack2.push(head2.value);
			head2 = head2.next;
		}
		int ca = 0;
		int n = 0;
		int n1 = 0;
		int n2 = 0;
		Node node = null;
		Node pre = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			n1 = stack1.isEmpty() ? 0 : stack1.pop();
			n2 = stack2.isEmpty() ? 0 : stack2.pop();
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}

	public static Node addLists2(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		int ca = 0;
		int n = 0;
		int n1 = 0;
		int n2 = 0;
		Node c1 = head1;
		Node c2 = head2;
		Node node = null;
		Node pre = null;
		while (c1 != null || c2 != null) {
			n1 = c1 != null ? c1.value : 0;
			n2 = c2 != null ? c2.value : 0;
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		reverseList(head1);
		reverseList(head2);
		return node;
	}

	public static Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(9);
		head1.next = new Node(9);
		head1.next.next = new Node(9);

		Node head2 = new Node(1);

		printLinkedList(head1);
		printLinkedList(head2);
		printLinkedList(addLists1(head1, head2));
		printLinkedList(addLists2(head1, head2));

	}

}
