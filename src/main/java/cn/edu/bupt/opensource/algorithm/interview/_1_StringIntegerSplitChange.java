package cn.edu.bupt.opensource.algorithm.interview;

import java.util.Scanner;

/**
 * <p>Title: _1_StringIntegerSplitChange</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-08 18:47</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 字符串形式的正整数（可能包含前缀0，1<=length<=10）
 *  先将此字符串拆分为两部分，接着可以在这两个部分中分别加入、或不加入小数点，分别形成一个小数、或整数；
 *  找出所有经“拆分”和“变化”两次操作后所有可能的组合。
 *  要求：
 *      1）对于新形成的小数或整数，不可包含多余的前缀0，例如：0010、010.1不合法；
 *      2）对于小数，不可包含多余的后缀0，例如：0.10不合法；
 *      3）.1和1.这样的小数不合法
 *
 */
public class _1_StringIntegerSplitChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int sum = 0;
        for (int i = 1; i <= str.length() - 1; i++) {
            sum += subSum(str.substring(0, i)) * subSum(str.substring(i));
        }
        System.out.println(sum);
    }

    private static int subSum(String str) {
        if (str.length() == 1) {
            return 1;
        }
        if (str.charAt(str.length() - 1) == '0' && str.charAt(0) == '0') {
            return 0;
        }
        if (str.charAt(str.length() - 1) == '0' || str.charAt(0) == '0') {
            return 1;
        }
        return str.length();
    }

}
