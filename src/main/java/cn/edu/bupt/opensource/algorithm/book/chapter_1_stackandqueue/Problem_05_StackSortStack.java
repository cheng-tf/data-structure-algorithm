package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 题目：用一个栈实现另一个栈的排序
 * 要求：实现从大到小排序，只允许申请一个栈、新的变量，不允许申请额外的数据结构
 * 提示：
 * 	1 排序栈为stack，申请的辅助栈为help
 * @author john
 *
 */
public class Problem_05_StackSortStack {

	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while (!help.isEmpty() && cur > help.peek()){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		sortStackByStack(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
