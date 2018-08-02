package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.LinkedList;

/**
 * 题目：最大值减去最小值小于或等于num的子数组数量
 * 要求：若数组长度为N，则要求时间复杂度为O(N)
 * 结论：
 * 	1 若子数组arr[i..j]满足条件，则其每一个子数组arr[k..l](i<=k<=l<=j)也都满足条件。
 * 	2 若子数组arr[i..j]不满足条件，则所有包含此子数组的子数组也都不满足条件。
 * 提示：
 * 	1 使用双端队列结构，qmax维护窗口子数组的最大值更新，qmin维护窗口子数组的最小值更新
 * 	2 所有的下标值最多仅qmax和qmin一次，出qmax和qmin一次，且i和j的值不断增加。
 * @author john
 *
 */
public class Problem_10_AllLessNumSubArray {

	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int res = 0;
		while (i < arr.length) {
			while (j < arr.length) {
				while (!qmin.isEmpty() && arr[j] <= arr[qmin.peekLast()]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty() && arr[j] >= arr[qmax.peekLast()]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
					break;
				}
				j++;
			}
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			res += j - i;
			i++;
		}
		return res;
	}

	// for test
	public static int[] getRandomArray(int len) {
		if (len < 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = getRandomArray(30);
		int num = 5;
		printArray(arr);
		System.out.println(getNum(arr, num));

	}

}
