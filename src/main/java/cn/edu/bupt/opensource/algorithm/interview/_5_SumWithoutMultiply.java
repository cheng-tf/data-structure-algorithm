package cn.edu.bupt.opensource.algorithm.interview;
/**
 * <p>Title: _5_SumWithoutMultiply</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-26 23:17</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 题目描述：
 *      求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字、条件判断语句（A?B:C）。
 *
 */
public class _5_SumWithoutMultiply {

    private static int sum(int n) {
        int sum = n;
        boolean boo =  (n > 0) && ((sum += sum(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(-100));
        System.out.println(sum(100));
    }

}
