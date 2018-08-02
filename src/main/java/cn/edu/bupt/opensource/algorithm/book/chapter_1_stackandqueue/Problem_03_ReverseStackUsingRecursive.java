package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 题目：如何仅使用递归函数和栈操作，实现栈中元素的逆序
 * 要求：不能使用其他数据结构
 * 提示：
 * 	1 递归函数1：将栈stack的栈底元素返回并移除
 * 	2 递归函数2：逆序一个栈
 * @author john
 *
 */
public class Problem_03_ReverseStackUsingRecursive {

	/**
	 * 逆序一个栈
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	/**
	 * 将栈stack的栈底元素返回并移除
	 * @param stack
	 * @return
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.empty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}


	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}

}
