package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _2_ShellSort</p>
 * <p>Description: 希尔排序 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-02 15:54</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 希尔排序是1959 年由D.L.Shell 提出来的，相对直接插入排序有较大的改进。希尔排序又叫缩小增量排序。
 * 基本思想：
 *      先将整个待排序的记录序列，分割成为若干子序列分别进行直接插入排序；
 *      待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * 操作方法：
 *      1）选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *      2）按增量序列个数k，对序列进行k 趟排序；
 *      3）每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *         仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * 注意：
 *      希尔排序时效分析很难，关键码的比较次数与记录移动次数依赖于增量因子序列d的选取，特定情况下可以准确估算出关键码的比较次数和记录的移动次数。
 *      目前还没有人给出选取最好的增量因子序列的方法。
 *      增量因子序列可以有各种取法，有取奇数的，也有取质数的，但需要注意：增量因子中除1 外没有公因子，且最后一个增量因子必须为1。
 *      希尔排序是一个不稳定的排序方法。
 */
public class _2_ShellSort {

    /**
     * 希尔排序
     * @param arr
     * 增量序列为：d = {n/2 ,n/4, n/8 .....1}，其中n为数组长度
     */
    private void shellSort(int[] arr) {
        int dk = arr.length/2;
        while(dk >= 1) {
            shellInsertSort(arr, dk);
            dk = dk/2;
        }
    }

    /**
     * 类似基本插入排序，只是插入增量为dk，而不是1
     * @param arr   待排序序列
     * @param dk    增量
     */
    private void shellInsertSort(int[] arr, int dk) {
        int i, j, x;
        int len = arr.length;
        for(i = dk; i < len; i++) {
            if(arr[i] < arr[i-dk]) {
                x = arr[i];
                for(j=i-dk; j>=0 && x<arr[j]; j-=dk) {
                    arr[j+dk] = arr[j];
                }
                arr[j+dk] = x;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        shellSort(arr);
        System.out.print("希尔排序：");
        outArr(arr);
    }

    // 输出结果
    private static void outArr(int[] arr) {
        StringBuilder str = new StringBuilder();
        for(int num : arr){
            str.append(num).append(',');
        }
        str.deleteCharAt(str.length() - 1);
        System.out.println(str.toString());
    }


}
