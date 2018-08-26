package cn.edu.bupt.opensource.algorithm.leetcode.array;

import org.junit.Test;

/**
 * <p>Title: _209_MinimumSizeSubarraySum</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 16:19</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 * 示例:
 *      输入: s = 7, nums = [2,3,1,2,4,3]
 *      输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶: 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */
public class _209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // 基于滑动窗口
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right++];
            while(sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

}
