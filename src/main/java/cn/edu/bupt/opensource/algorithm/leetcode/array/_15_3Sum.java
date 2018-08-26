package cn.edu.bupt.opensource.algorithm.leetcode.array;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: _15_3Sum</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 15:10</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 *      [
 *          [-1, 0, 1],
 *          [-1, -1, 2]
 *      ]
 *
 */
public class _15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        // #1 排序
        Arrays.sort(nums);
        // #2 遍历，跳过重复元素，进行双向扫描
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSONUtil.parse(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
    }

}
