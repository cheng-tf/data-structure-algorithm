package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _1_InsertSort</p>
 * <p>Description: 基本插入排序 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-02 11:51</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 基本思想：
 *      将一个记录插入到已排序好的有序表中，从而得到一个新的记录数增1的有序表。
 *      即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 * 注意：相等元素的前后顺序不改变。
 *
 *
 *
 */
public class _1_InsertSort {

    /**
     * 基本插入排序
     * @param arr
     */
    private static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] < arr[i-1]) {
                int x = arr[i];//x为待插入元素
                int j;
                for (j = i-1; j >= 0 && x < arr[j]; j--) {  // 通过循环，逐个后移一位寻找要插入的位置
                    arr[j+1] = arr[j];
                }
                arr[j+1] = x;// 插入
            }
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        insertSort(arr);
        System.out.print("基本插入排序：");
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
