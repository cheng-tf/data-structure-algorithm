package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _5_BubbleSort</p>
 * <p>Description: 冒泡排序</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-08 19:05</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 冒泡排序（Bubble Sort）
 *  基本思想：
 *      在待排序一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 *      即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。

 *  冒泡排序算法的改进：加入一标志性变量exchange，用于标志某一趟排序过程中是否有数据交换；若没有则立即结束排序。
 *  两种改进算法：
 *      1）设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
 *         由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
 *      2）传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值。
 *         我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) , 从而使排序趟数几乎减少了一半。
 */
public class _5_BubbleSort {


    /**
     * 冒泡排序
     * @param arr
     */
    private void bubbleSort(int[] arr) {
        int len = arr.length;
        int temp;
        for(int i=0; i < len-1; i++) {
            for(int j=0; j < len-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 改进的冒泡排序2
     * @param arr
     */
    private void improvedBubbleSort(int[] arr) {
        int i = arr.length-1;
        int j, temp, pos;
        while(i > 0) {
            pos = 0;
            for(j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    pos = j;
                    temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
            i = pos;
        }
    }

    /**
     * 改进的冒泡排序2
     * @param arr
     */
    private void improvedBubbleSort2(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int j, temp;
        while(low < high) {
            for(j = low; j < high; j++) {//正向冒泡，找到最大者
                if(arr[j] > arr[j+1]) {
                    temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
            --high;
            for(j = high; j > low; j--) {//反向冒泡，找到最小者
                if(arr[j] < arr[j-1]) {
                    temp = arr[j]; arr[j] = arr[j-1]; arr[j-1] = temp;
                }
            }
            ++low;
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("排序前：");
        outArr(arr);
        System.out.println();
        bubbleSort(arr);
        System.out.print("冒泡排序：");
        outArr(arr);
        System.out.println();
        arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        improvedBubbleSort(arr);
        System.out.print("改进的冒泡排序：");
        outArr(arr);
        System.out.println();
        arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        improvedBubbleSort2(arr);
        System.out.print("改进的冒泡排序2：");
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
