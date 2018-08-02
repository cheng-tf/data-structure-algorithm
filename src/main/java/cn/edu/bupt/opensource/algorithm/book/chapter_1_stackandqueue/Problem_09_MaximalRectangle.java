package cn.edu.bupt.opensource.algorithm.book.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 题目：求最大子矩阵的大小
 * 要求：若矩阵的大小为N*M，且矩阵元素只有1和0，则要求时间复杂度为O(N*M)
 * 提示：
 * 	1 for循环进行N次切割，每一次得到一个height数组
 * 	2 根据height数组，求解以每一行为底时，其中的最大矩形（实质是在一个大的直方图中秋最大矩形的面积），使用栈来完成
 * @author john
 *
 */
public class Problem_09_MaximalRectangle {

	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxArea, maxRedFromBottom(height));
		}
		return maxArea;
	}

	public static int maxRedFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++){
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				maxArea = Math.max(maxArea, (i - k - 1)*height[j]);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			maxArea = Math.max(maxArea, (height.length - k - 1)*height[j]);
		}
		return maxArea;
	}


	public static void main(String[] args) {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
		System.out.println(maxRecSize(map));
	}

}
