package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _4_HeapSort</p>
 * <p>Description: 堆排序 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-08 19:02</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 堆排序（Heap Sort）： 一种树形选择排序，是对直接选择排序的有效改进。
 *
 *
 *
 *
 *
 *
 *
 */
public class _4_HeapSort {


    /**
     * 堆排序
     * @param arr
     */
    private void heapSort(int[] arr) {

    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        heapSort(arr);
        System.out.print("堆排序：");
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
