package cn.edu.bupt.opensource.algorithm.sort;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: _7_MergeSortKPath</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-21 11:17</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 多路归并排序
 *      从2路到多路（k路），增大k可以减少外存信息读写时间，但k个归并段中选取最小的记录需要比较k-1次，为得到u个记录的一个有序段共需要(u-1)(k-1)次。
 *      若归并趟数为s次，那么对n个记录的文件进行外排时，内部归并过程中进行的总的比较次数为s(n-1)(k-1)。
 *      若共有m个归并段，则s=logkm，所以总的比较次数为： (向上取整)(logkm)(k-1)(n-1)=(向上取整)(log2m/log2k)(k-1)(n-1)，
 *      而(k-1)/log2k随k增而增因此内部归并时间随k增长而增长了，抵消了外存读写减少的时间，
 *      这样做不行，由此引出了“败者树”tree of loser的使用。
 *      在内部归并过程中利用败者树将k个归并段中选取最小记录比较的次数降为(向上取整)(log2k)次使总比较次数为(向上取整)(log2m)(n-1)，与k无关。
 * 败者树：
 *      叶子节点记录k个段中的最小数据，然后两两进行比赛。
 *      败者树是在双亲节点中记录下刚刚进行完的这场比赛的败者，让胜者去参加更高一层的比赛。
 *      决赛，根节点记录输者，所以需要重建一个新的根节点，记录胜者。
 *
 */
public class _7_MergeSortKPath {

    private List<Integer> kPathMergeSort(List<List<Integer>> list) {



        return null;
    }

    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream( new int[]{13, 27, 38, 49, 65, 76, 97} ).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream( new int[]{1, 14, 66, 78, 100} ).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream( new int[]{7, 15, 23, 37, 56, 78} ).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream( new int[]{5, 50, 100} ).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream( new int[]{3, 35, 45, 67, 79, 99, 100, 150} ).boxed().collect(Collectors.toList()));
        System.out.print("多路归并排序：");
        System.out.println(JSONUtil.toJsonStr(kPathMergeSort(list)));
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
