package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 题目：用栈来解决汉诺塔问题
 * 要求：必须经过中间，将汉诺塔从左移至右
 * 方案：
 * 	1 采用递归方法
 * 	2 采用非递归方法，使用栈来模拟汉诺塔的三个塔		// 推荐
 * 提示：
 * 	1 抽象成三个栈：LS、MS、RS
 * 	2 原则：小压大 && 相邻不可逆原则
 * 	3 结论：每一步都只有一个动作达标（符合此两个原则），按顺序进行即可。
 * @author john
 *
 */
public class Problem_06_HanoiStack {

	public static int hanoiProblem1(int num, String left, String mid,
									String right) {
		if (num < 1) {
			return 0;
		}
		return process(num, left, mid, right, left, right);
	}

	public static int process(int num, String left, String mid, String right,
							  String from, String to) {
		if (num == 1) {
			if (from.equals(mid) || to.equals(mid)) {
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 2;
			}
		}
		if (from.equals(mid) || to.equals(mid)) {
			String another = (from.equals(left) || to.equals(left)) ? right : left;
			int part1 = process(num - 1, left, mid, right, from, another);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);
			int part3 = process(num - 1, left, mid, right, another, to);
			return part1 + part2 + part3;
		} else {
			int part1 = process(num - 1, left, mid, right, from, to);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + mid);
			int part3 = process(num - 1, left, mid, right, to, from);
			int part4 = 1;
			System.out.println("Move " + num + " from " + mid + " to " + to);
			int part5 = process(num - 1, left, mid, right, from, to);
			return part1 + part2 + part3 + part4 + part5;
		}
	}

	/**
	 * 枚举类型：定义动作
	 * @author john
	 *
	 */
	public enum Action {
		No, LToM, MToL, MToR, RToM
	}

	/**
	 * Function：
	 * @param num	层数
	 * @param left
	 * @param mid
	 * @param right
	 * @return
	 */
	public static int hanoiProblem2(int num, String left, String mid, String right) {
		Stack<Integer> lS = new Stack<Integer>();
		Stack<Integer> mS = new Stack<Integer>();
		Stack<Integer> rS = new Stack<Integer>();
		lS.push(Integer.MAX_VALUE);
		mS.push(Integer.MAX_VALUE);
		rS.push(Integer.MAX_VALUE);
		for (int i = num; i > 0; i--) {
			lS.push(i);
		}
		Action[] record = { Action.No };
		int step = 0;
		while (rS.size() != num + 1) {
			step += fStackToStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
			step += fStackToStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
			step += fStackToStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
			step += fStackToStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
		}
		return step;
	}

	/**
	 * Function：完成每一步的动作，要求满足小压大、相邻不可逆原则
	 * @param record	动作记录
	 * @param preNoAct	前一个动作
	 * @param nowAct	现在的动作
	 * @param fStack
	 * @param tStack
	 * @param from
	 * @param to
	 * @return
	 */
	public static int fStackToStack(Action[] record, Action preNoAct, Action nowAct,
									Stack<Integer> fStack, Stack<Integer> tStack,
									String from, String to) {
		if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int num = 4;

		// solution 1
		int steps1 = hanoiProblem1(num, "left", "mid", "right");
		System.out.println("It will move " + steps1 + " steps.");
		System.out.println("===================================");

		// solution 2
		int steps2 = hanoiProblem2(num, "left", "mid", "right");
		System.out.println("It will move " + steps2 + " steps.");
		System.out.println("===================================");

	}

}