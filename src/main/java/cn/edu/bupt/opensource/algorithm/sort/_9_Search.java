package cn.edu.bupt.opensource.algorithm.sort;

import org.junit.Test;

/**
 * <p>Title: _9_Search</p>
 * <p>Description: 查找算法 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-09 12:50</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class _9_Search {

    /**
     * 顺序查找
     */
    private boolean orderSearch(int[] arr, int keyword) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            if(arr[i] == keyword) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     * 前提条件：必须是有序的序列
     * 二分查找是一种效率比较高的查找算法，但是它依赖于数组有序的存储。
     *      二分查找的过程可以用二叉树来形容描述：把当前查找区间的中间位置上的结点作为根，左子表和右子表中的结点分别作为根节点的左子树和右子树。
     *      由此得到的二叉树，称为描述二分查找树的判定树（Decision Tree）或比较树（Comprision Tree）。时间复杂度为O(logN)。
     * 二分查找就是将给定值K与二分查找判定树的根节点的关键字进行比较。
     * 虽然二分查找的效率很高，但是要将表按关键字排序。
     * 因此，二分查找特别适用于那种一经建立就很少改动、而又经常需要查找的线性表。
     * 一般情况下，表长为n的折半查找的判定树的深度和含有n个节点的完全二叉树的深度相同。
     */
    private boolean binarySearch(int[] arr, int keyword) {
        int low = 0;
        int high = arr.length-1;
        int mid;
        while(low < high) {
            mid = (low + high)/2;
            if(arr[mid] > keyword) {
                high = mid - 1;
            } else if(arr[mid] < keyword) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        System.out.print("顺序查找：" + orderSearch(arr, 76));
        System.out.println();
        arr = new int[]{13, 27, 38, 49, 65, 76, 97};
        System.out.print("二分查找：" + binarySearch(arr, 76));
    }

    @Test
    public void testBST() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        BSTree<Integer> tree=new BSTree<Integer>();
        int len = arr.length;
        System.out.print("== 依次添加: ");
        for(int i=0; i<len; i++) {
            System.out.print(arr[i]+" ");
            tree.insert(arr[i]);
        }
        System.out.print("\n== 前序遍历: ");
        tree.preOrder();
        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();
        System.out.println("== 最小值: "+ tree.minimum());
        System.out.println("== 最大值: "+ tree.maximum());
        System.out.println("== 树的详细信息: ");
        tree.print();
        System.out.print("\n== 删除根节点: "+ arr[3]);
        tree.remove(arr[3]);
        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.println();
        // 销毁二叉树
        tree.clear();
    }



}
