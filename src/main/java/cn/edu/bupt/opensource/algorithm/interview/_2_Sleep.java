package cn.edu.bupt.opensource.algorithm.interview;

/**
 * <p>Title: _2_Sleep</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-21 11:46</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 2018/08/11 网易
 * 瞌睡
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。
 * 你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。
 * 你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述:
 *      第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 *      第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 *      第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * 输出描述: 小易这堂课听到的知识点的最大兴趣值。
 * 示例1
 * 输入
 *      6 3
 *      1 3 5 2 5 4
 *      1 1 0 1 0 0
 * 输出
 *      16
 *
 */
public class _2_Sleep {

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int minutes = Integer.parseInt(str[0]);
        int delay = Integer.parseInt(str[1]);
        int[] interests = new int[minutes];
        int[] awake = new int[minutes];
        int now = 0;
        str = in.nextLine().split(" ");
        for(int i = 0; i < minutes; i++) {
            interests[i] = Integer.parseInt(str[i]);
        }
        str = in.nextLine().split(" ");
        for(int i = 0; i < minutes; i++) {
            awake[i] = Integer.parseInt(str[i]);
            now += awake[i]*interests[i];
        }
        */
        int minutes = 6;
        int delay = 3;
        int[] interests = new int[]{1, 3, 5, 2, 5, 4};
        int[] awake = new int[]{1, 1, 0, 1, 0, 0};
        int now = 0;
        for(int i = 0; i < minutes; i++) {
            now += awake[i]*interests[i];
        }
        // 基于长度为delay的滑动窗口做个dp
        int res = now;
        for(int i = 0; i < minutes;) {
            now += (1 - awake[i]) * interests[i];
            if(++i >= delay) {
                res = Math.max(res, now);
                now -= (1 - awake[i - delay]) * interests[i - delay];
            }
        }
        System.out.println(res);
    }

}
