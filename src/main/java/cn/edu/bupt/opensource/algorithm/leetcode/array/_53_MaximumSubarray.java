package cn.edu.bupt.opensource.algorithm.leetcode.array;

/**
 * <p>Title: _53_MaximumSubarray</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-21 14:25</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 *      输入: [-2,1,-3,4,-1,2,1,-5,4],
 *      输出: 6
 *      解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */
public class _53_MaximumSubarray {

    /**
     * time:O(n)
     * space:O(1)
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * time:O(n)
     * space:O(n)
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];//dp[i]表示以nums[i]为末尾的最大子序和
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < len; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
