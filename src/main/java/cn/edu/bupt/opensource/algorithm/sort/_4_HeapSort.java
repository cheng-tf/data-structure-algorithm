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
 * 堆排序（Heap Sort）： 一种树形选择排序，是对直接选择排序的改进。
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
     * 堆排序（大顶堆）
     */
    private void heapSort(int[] arr) {
        buildMaxHead(arr);//初始堆
        for(int i = arr.length-1; i > 1; i--) {
            int temp = arr[0];//将堆顶元素与堆底元素交换
            arr[0] = arr[i];
            arr[i] = temp;
            adjustDownToUp(arr, 0, i);//将剩余元素整理构建新的大顶堆
        }
    }

    /**
     * 建立初始堆
     */
    private void buildMaxHead(int[] arr) {
        // 从最后一个节点arr.length-1的父节点（array.length-2）/2开始，直到根节点，反复调整堆
        for(int i = (arr.length-2)/2; i >= 0; i--) {
            adjustDownToUp(arr, i, arr.length);
        }
    }

    /**
     * 将元素arr[k]自下往上逐步调整树形结构
     */
    private void adjustDownToUp(int[] arr, int k, int len) {
        int temp = arr[k];
        // i为初始化节点k的左孩子，沿较大子节点向下调整
        for(int i = 2*k+1; i < len-1; i=2*i+1) {
            if(i < len && arr[i] < arr[i+1]) {
                i++;//右孩子
            }
            // 若父节点 >= 左右孩子中较大者，则调整结束，否则互换
            if(temp >= arr[i]) {
                break;
            } else {
                arr[k] = arr[i];
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        arr[k] = temp;
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
