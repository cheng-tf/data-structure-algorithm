package cn.edu.bupt.opensource.algorithm.leetcode.math;
/**
 * <p>Title: _326_PowerofThree</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 19:35</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class _326_PowerofThree {

    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n>0 && 1162261467%n == 0);
    }

}
