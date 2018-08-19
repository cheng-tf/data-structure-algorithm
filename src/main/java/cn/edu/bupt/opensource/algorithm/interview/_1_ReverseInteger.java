package cn.edu.bupt.opensource.algorithm.interview;

import org.junit.Test;

/**
 * <p>Title: _1_ReverseInteger</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-18 12:47</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 2018/08/17 美团
 *
 * 给定一个整数，进行翻转。例如：123，输出321.
 */
public class _1_ReverseInteger {

    private int reverse(int num) {
        if(num < 0) {
            return num;
        }
        int res = 0;
        while(num != 0) {
            res = res*10 + num%10;
            num = num/10;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(reverse(1234567));
    }

}
