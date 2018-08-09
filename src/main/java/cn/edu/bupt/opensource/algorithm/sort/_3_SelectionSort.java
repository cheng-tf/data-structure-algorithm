package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _3_SelectionSort</p>
 * <p>Description: 选择排序</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-02 16:15</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 简单选择排序（Simple Selection Sort）
 * 基本思想：
 *      在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
 *      然后，在剩下的数当中再找最小（或者最大）的与第2个位置的数交换；
 *      依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 * 操作方法：
 *      第一趟，从n 个记录中找出关键码最小的记录与第一个记录交换；
 *      第二趟，从第二个记录开始的n-1 个记录中再选出关键码最小的记录与第二个记录交换；
 *      以此类推.....
 *      第i 趟，则从第i 个记录开始的n-i+1 个记录中选出关键码最小的记录与第i 个记录交换，直到整个序列按关键码有序。
 *
 * 简单选择排序的改进——二元选择排序
 * 基本思想：
 *      简单选择排序，每趟循环只能确定一个元素排序后的定位。
 *      改进：每趟循环确定两个元素（当前趟最大和最小记录）的位置,从而减少排序所需的循环次数。
 *      改进后对n个数据进行排序，最多只需进行[n/2]趟循环即可。
 *
 *
 */
public class _3_SelectionSort {

    /**
     * 简单选择排序
     * @param arr
     */
    private void simpleSelectionSort(int[] arr) {
        int len = arr.length;
        int i, j, min, temp;
        for(i = 0; i < len; i++) {
            min = i;//最小值下标
            for(j = i+1; j < len; j++) {//向后遍历寻找最小值下标
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min]; arr[min] = arr[i]; arr[i] = temp;//交换位置
        }
    }

    /**
     * 二元选择排序
     * @param arr
     */
    private void simpleSelectionSort2(int[] arr) {
        int len = arr.length;
        int i, j, min, max, temp;
        for(i=1; i<=len/2; i++) {//n/2趟选择排序
            min = i;//最小值下标
            max = i;//最大值下标
            for(j = i; j < len-i; j++) {//向后遍历寻找最小值、最大值下标
                if(arr[min] > arr[j]) {
                    min = j;
                    continue;
                }
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }
            // 交换位置
            temp = arr[min]; arr[min] = arr[i-1]; arr[i-1] = temp;
            temp = arr[max]; arr[max] = arr[len-i]; arr[len-i] = temp;
        }
    }


    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        simpleSelectionSort(arr);
        System.out.print("简单选择排序：");
        outArr(arr);
        System.out.println();
        arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        simpleSelectionSort2(arr);
        System.out.print("二元选择排序：");
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
