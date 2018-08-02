package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 题目：使用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 * 提示：一个栈作为压入栈stackPush、另一个作为弹出栈StackPop。
 * 注意：
 * 	1 若stackPush要往stackPop中亚茹数据，必须一次性全部压入
 * 	2 若stackPop不为空，则stackPush绝对不能向stackPop压入数据。
 * @author john
 *
 */
public class Problem_02_TwoStacksImplementQueue {

	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void add(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPush.empty() && stackPop.empty()) {
				throw new RuntimeException("Queue is empty.");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPush.empty() && stackPop.empty()) {
				throw new RuntimeException("Queue is empty.");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}


	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}

}
