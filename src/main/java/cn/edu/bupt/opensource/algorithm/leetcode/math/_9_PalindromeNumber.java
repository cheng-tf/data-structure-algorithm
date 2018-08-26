package cn.edu.bupt.opensource.algorithm.leetcode.math;

import org.junit.Test;

/**
 * <p>Title: _9_PalindromeNumber</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-19 17:00</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *      输入: 121
 *      输出: true
 * 示例 2:
 *      输入: -121
 *      输出: false
 *      解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *      输入: 10
 *      输出: false
 *      解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶: 你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class _9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 反转后半区数字
        int revertedNum = 0;
        while(x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x = x / 10;
        }
        return x == revertedNum || x == revertedNum/10;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

}
