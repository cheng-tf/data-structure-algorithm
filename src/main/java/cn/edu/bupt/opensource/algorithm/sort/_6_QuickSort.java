package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _6_QuickSort</p>
 * <p>Description: 快速排序 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-08 19:25</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 快速排序（Quick Sort）
 *  分治-递归算法
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
 *
 */
public class _6_QuickSort {

    /**
     * 快速排序
     * @param arr
     */
    private void quickSort(int[] arr) {
        int len = arr.length;
        if(len > 0) {
            quickSort(arr, 0, len-1);
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if(low >= high) {//递归结束条件
          return;
        }
        /*
        // 三位取中法
        int mid = (low + high) / 2;
        if(arr[low] > arr[high]) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        if(arr[mid] > arr[high]) {
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
        }
        if(arr[mid] > arr[low]) {
            int temp = arr[mid];
            arr[mid] = arr[low];
            arr[low] = temp;
        }
        int key = arr[low];
        */
        int key = arr[low];//基准元素，在此趟排序时空出一个位置
        int left = low, right = high;//存储
        while(left < right) {
            while(left < right && arr[right] >= key) {//从高位right寻找比基准小的元素，与低位left交换位置
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= key) {//从低位left寻找比基准大的元素，与高位right交换位置
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;//此时left=right，即基准元素在排好序后的正确位置
        quickSort(arr, low, left-1);//低子序列递归排序
        quickSort(arr, left+1, high);//高子序列递归排序
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
