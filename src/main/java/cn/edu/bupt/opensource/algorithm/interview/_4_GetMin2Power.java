package cn.edu.bupt.opensource.algorithm.interview;

/**
 * <p>Title: _4_GetMin2Power</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-26 23:06</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 题目描述：
 *      任意给定一个数，返回大于等于它的最小的2的乘方。
 *
 */
public class _4_GetMin2Power {


    private static int getMin2Power(int n){
        n = n - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0)?1:n+1;
    }

    public static void main(String[] args) {
        System.out.println(getMin2Power(13));
        System.out.println(getMin2Power(128));
        System.out.println(getMin2Power(6389));
    }

}

