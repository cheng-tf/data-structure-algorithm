package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _6_quickSort</p>
 * <p>Description: 快速排序 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-08 19:25</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 快速排序（Quick Sort）
 *  基本思想：
 *      1）选择一个基准元素,通常选择第一个元素或者最后一个元素；
 *      2）通过一趟排序将待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的元素值比基准值大；
 *      3）此时基准元素在其排好序后的正确位置；
 *      4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
 *  分析：
 *      快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
 *      但是，当初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。
 *      改进：通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。
 *      快速排序是一个不稳定的排序方法。
 *  快速排序的改进：
 *      在本改进算法中,只对长度大于k的子序列递归调用快速排序,让原序列基本有序，然后再对整个基本有序序列用插入排序算法排序。
 *      实践证明，改进后的算法时间复杂度有所降低，且当k取值为 8 左右时,改进算法的性能最佳。
 *
 */
public class _6_quickSort {

    /**
     * 快速排序
     * @param arr
     */
    private void quickSort(int[] arr) {

    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        quickSort(arr);
        System.out.print("快速排序：");
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
