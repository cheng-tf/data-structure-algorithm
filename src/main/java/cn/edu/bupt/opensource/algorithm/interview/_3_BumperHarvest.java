package cn.edu.bupt.opensource.algorithm.interview;

/**
 * <p>Title: _3_BumperHarvest</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-21 12:47</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 2018/08/11 网易
 * 丰收
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 * 输入描述:
 *      第一行一个数n(1 <= n <= 105)。
 *      第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 *      第三行一个数m(1 <= m <= 105)，表示有m次询问。
 *      第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * 输出描述:
 *      m行，第i行输出第qi个苹果属于哪一堆。
 * 示例1
 * 输入
 *      5
 *      2 7 3 4 9
 *      3
 *      1 25 11
 * 输出
 *      1
 *      5
 *      3
 *
 */
public class _3_BumperHarvest {

    // 二分法
    private static int func(int num, int[] apples) {
        int low = 0;
        int high = apples.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if (num == apples[mid])
                return mid + 1;
            else if (num > apples[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low + 1;
    }

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int numHeap = Integer.parseInt(in.nextLine());
        int[] apples = new int[numHeap];
        String[] str = in.nextLine().split(" ");
        for(int i = 0; i < numHeap; i++) {
            if(i == 0) {
                apples[i] = Integer.parseInt(str[i]);
            } else {
                apples[i] = Integer.parseInt(str[i]) + apples[i-1];
            }
        }
        int timeQuery = Integer.parseInt(in.nextLine());
        int[] numQuery = new int[timeQuery];
        int[] res = new int[timeQuery];
        str = in.nextLine().split(" ");
        for(int i = 0; i < timeQuery; i++) {
            numQuery[i] = Integer.parseInt(str[i]);
            res[i] = func(numQuery[i], apples);
        }
        for(int i = 0; i < timeQuery; i++) {
            System.out.println(res[i]);
        }
        */

        int numHeap = 5;//堆数
        int[] apples = new int[]{2, 7, 3, 4, 9};//每堆的苹果数
        int timeQuery = 3;//询问次数
        int[] numQuery = new int[]{1, 25, 11};//询问的苹果号
        int[] res = new int[timeQuery];
        for(int i = 1; i < numHeap; i++) {
            apples[i] += apples[i-1];
        }
        for(int i = 0; i < timeQuery; i++) {
            res[i] = func(numQuery[i], apples);
        }
        for(int i = 0; i < timeQuery; i++) {
            System.out.println(res[i]);
        }
    }

}
