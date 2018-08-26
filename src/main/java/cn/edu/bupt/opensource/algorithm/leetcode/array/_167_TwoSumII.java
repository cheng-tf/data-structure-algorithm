package cn.edu.bupt.opensource.algorithm.leetcode.array;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

/**
 * <p>Title: _167_TwoSumII</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 16:07</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 *      返回的下标值（index1 和 index2）不是从零开始的。
 *      你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *      输入: numbers = [2, 7, 11, 15], target = 9
 *      输出: [1,2]
 *      解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class _167_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length == 1) {
            return res;
        }
        // 基于对撞指针
        int low = 0;
        int high = numbers.length-1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                res[0] = low + 1;
                res[1] = high + 1;
                break;
            } else if(sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(JSONUtil.parse(twoSum(nums, 9)));
    }

}
