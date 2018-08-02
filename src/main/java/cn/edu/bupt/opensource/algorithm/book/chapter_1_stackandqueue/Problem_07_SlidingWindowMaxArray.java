package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.LinkedList;

/**
 * 题目：生成窗口最大值数组
 * 要求：时间复杂度为O(N)，而不是O(N*w)
 * 	输入：整型数组arr，窗口大小为w
 * 	输出：一个长度为n-w+1的数组red，res[i]表示每一种窗口状态下的最大值
 * 提示：
 * 	1 关键在于使用双端队列qmax
 * 	2 定义qmax的放入规则、弹出规则
 * @author john
 *
 */
public class Problem_07_SlidingWindowMaxArray {

	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			// 放入规则
			while (!qmax.isEmpty() && arr[i] >= qmax.peekLast()) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			// 弹出规则
			if (qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int w = 3;
		printArray(getMaxWindow(arr, w));

	}

}
