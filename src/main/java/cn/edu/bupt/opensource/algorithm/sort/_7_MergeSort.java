package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _7_MergeSort</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-21 10:48</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 归并排序（分解-合并思想）
 * 归并排序法：将两个（或两个以上）有序表合并成一个新的有序表，
 *             即把待排序序列分为若干个子序列，每个子序列是有序的，然后再把有序子序列合并为整体有序序列。
 * 两路归并：分而治之(divide - conquer);
 *      每个递归过程涉及三个步骤：
 *      第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
 *      第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
 *      第三, 合并: 合并两个排好序的子序列,生成排序结果.
 *
 */
public class _7_MergeSort {

    /**
     * 归并排序
     * @param arr
     */
    private void mergeSort(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int []temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    /**
     * 分解
     */
    private void sort(int[] arr, int low, int high, int[] temp) {
        if(low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid, temp);//左子序列归并排序
            sort(arr, mid+1, high, temp);//右子序列归并排序
            merge(arr, low, mid, high, temp);//合并
        }
    }

    /**
     * 合并
     */
    private void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low;//左子序列指针
        int j = mid+1;//右子序列指针
        int k = 0;//临时数组指针
        // 将较小数转移至temp
        while(i <= mid && j <= high) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 将左序列剩余元素填充至temp
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        // 将右序列剩余元素填充至temp
        while(j <= high) {
            temp[k++] = arr[j++];
        }
        k = 0;
        // 将temp中的元素全部拷贝到原数组中
        while(low <= high){
            arr[low++] = temp[k++];
        }
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
