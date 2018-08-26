package cn.edu.bupt.opensource.algorithm.leetcode.math;

import org.junit.Test;

/**
 * <p>Title: _7_ReverseInteger</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 16:44</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 *      输入: 123
 *      输出: 321
 * 示例 2:
 *      输入: -123
 *      输出: -321
 * 示例 3:
 *      输入: 120
 *      输出: 21
 *
 */
public class _7_ReverseInteger {

    /**
     * time:O(log(x))
     * space:O(1)
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            // 若反转后整数溢出，则返回0
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(reverse(1234));
        System.out.println(reverse(-1234));
        System.out.println(reverse(1230));
    }

}
