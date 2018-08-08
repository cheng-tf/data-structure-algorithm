package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _7_MergeSort</p>
 * <p>Description: 归并排序 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-08 19:29</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 归并排序
 *  基本思想：（分解-合并思想）
 *      归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
 *      然后再把有序子序列合并为整体有序序列。
 *  合并方法：（借助辅助数组将两个有序表合并成新的的有序数组）
 *      设r[i…n]由两个有序子表r[i…m]和r[m+1…n]组成，两个子表长度分别为n-i+1、n-m。
 *      	j=m+1；k=i；i=i; //置两个子表的起始下标及辅助数组的起始下标
 *      	若i>m 或j>n，转⑷ //其中一个子表已合并完，比较选取结束
 *      	//选取r[i]和r[j]较小的存入辅助数组rf
 *              如果r[i]<r[j]，rf[k]=r[i]； i++； k++； 转⑵继续判断
 *              否则，rf[k]=r[j]； j++； k++； 转⑵继续判断
 *      	//将尚未处理完的子表中元素存入rf
 *              如果i<=m，将r[i…m]存入rf[k…n] //前一子表非空
 *              如果j<=n ,  将r[j…n] 存入rf[k…n] //后一子表非空
 *      	合并结束。
 *  一趟排序方法：
 *      一趟归并排序中，可能子序列的个数不是偶数，这样最后一个子序列的操作就需要分情况讨论，一共两种情况：
 *          	子序列的个数为偶数，最后一个子序列就需要与前一个子序列合并；
 *          	子序列的个数为奇数，最后一个子序列直接为新序列。
 *  归并的迭代算法：
 *      1 个元素的表总是有序的。所以对n 个元素的待排序列，每个元素可看成1 个有序子表。
 *      对子表两两合并生成n/2个子表，所得子表除最后一个子表长度可能为1外，其余子表长度均为2。
 *      再进行两两合并，直到生成n 个元素按关键码有序的表。
 *
 */
public class _7_MergeSort {


    /**
     * 归并排序
     * @param arr
     */
    private void mergeSort(int[] arr) {

    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        mergeSort(arr);
        System.out.print("归并排序：");
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
