package cn.edu.bupt.opensource.data.structure.list;

/**
 * <p>Title: MyArrayList</p>
 * <p>Description: 数组 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-09 19:15</p>
 * @author ChengTengfei
 * @version 1.0
 *
 *
 * 数组局限性：
 *      ① 插入快：对于无序数组，只是按照插入的顺序排列，只需要在数组末尾添加元素即可。但是有序数组却不一定了，它需要在指定的位置插入。
 *      ② 查找慢：当然如果根据下标来查找是很快的。但是通常我们都是根据元素值来查找，给定一个元素值，对于无序数组，我们需要从数组第一个元素开始遍历，直到找到那个元素。有序数组通过特定的算法查找的速度会比无需数组快，后面我们会讲各种排序算法。
 *      ③ 删除慢：根据元素值删除，我们要先找到该元素所处的位置，然后将元素后面的值整体向前面移动一个位置。也需要比较多的时间。
 *      ④ 数组一旦创建后，大小就固定了，不能动态扩展数组的元素个数。如果初始化你给一个很大的数组大小，那会白白浪费内存空间，如果给小了，后面数据个数增加了又添加不进去了。
 *
 *
 *
 *
 */
public class MyArrayList {

    // 定义一个数组
    private int [] intArray;

    // 定义数组的实际有效长度
    private int elems;

    // 定义数组的最大长度
    private int length;

    // 默认构造一个长度为50的数组
    public MyArrayList(){
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    // 构造函数，初始化一个长度为length 的数组
    public MyArrayList(int length){
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    /**
     * 获取数组的有效长度
     */
    public int getSize(){
        return elems;
    }

    /**
     * 遍历显示元素
     */
    public void display(){
        for(int i = 0 ; i < elems ; i++){
            System.out.print(intArray[i]+" ");
        }
        System.out.println();
    }

    /**
     * 添加元素
     * @param value 假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响。
     * @return      添加成功返回true,添加的元素超过范围了返回false
     */
    public boolean add(int value){
        if(elems == length){
            return false;
        }else{
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    /**
     * 根据下标获取元素
     * @return  查找下标值在数组下标有效范围内，返回下标所表示的元素
     *           查找下标超出数组下标有效值，提示访问下标越界
     */
    public int get(int i){
        if(i<0 || i>elems){
            System.out.println("访问下标越界");
        }
        return intArray[i];
    }

    /**
     * 查找元素
     * @return  查找的元素如果存在则返回下标值，如果不存在，返回 -1
     */
    public int find(int searchValue){
        int i ;
        for(i = 0 ; i < elems ;i++){
            if(intArray[i] == searchValue){
                break;
            }
        }
        if(i == elems){
            return -1;
        }
        return i;
    }

    /**
     * 删除元素
     * @return  如果要删除的值不存在，直接返回 false;否则返回true，删除成功
     */
    public boolean delete(int value){
        int k = find(value);
        if(k == -1){
            return false;
        }else{
            if(k == elems-1){
                elems--;
            }else{
                for(int i = k; i< elems-1 ; i++){
                    intArray[i] = intArray[i+1];

                }
                elems--;
            }
            return true;
        }
    }

    /**
     * 修改数据
     * @param oldValue  原值
     * @param newValue  新值
     * @return          修改成功返回true，修改失败返回false
     */
    public boolean modify(int oldValue,int newValue){
        int i = find(oldValue);
        if(i == -1){
            System.out.println("需要修改的数据不存在");
            return false;
        }else{
            intArray[i] = newValue;
            return true;
        }
    }

    public static void main(String[] args) {
        // 创建自定义封装数组结构，数组大小为4
        MyArrayList arrayList = new MyArrayList(4);
        // 添加4个元素
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        // 显示数组元素
        arrayList.display();
        // 根据下标为0的元素
        int i = arrayList.get(0);
        System.out.println(i);
        // 删除4的元素
        arrayList.delete(4);
        // 将元素3修改为33
        arrayList.modify(3, 33);
        arrayList.display();
    }

}
