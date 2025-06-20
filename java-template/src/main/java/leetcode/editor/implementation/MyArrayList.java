package leetcode.editor.implementation;

/**
 * ClassName: MyArrayList
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/6/20 8:57
 * @Version 1.0
 */
public class MyArrayList<E> {
    //真正存储数据的底层数组
    private E[] data;
    //记录当前元素的个数
    private int size;
    //默认初始容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data  = (E[])new Object[initCapacity];
        size = 0;
    }

    //将data数组的容量改为newCap
    public void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    //增
    public void add(int index,E e) {
        //检查索引越界
        checkPositionIndex(index);

        int cap = data.length;
        //看数组容量够不够,若数组容量不足,则进行扩容
        if (size == cap) {
            resize(2 * cap);
        }
        if (size == 0) {
            //插入新元素
            data[index] = e;
            size++;
        }else {
            //进行数据搬移
            for (int i = size - 1; i >= index; i--) {
                data[i+1] = data[i];
            }
            //插入新元素
            data[index] = e;
            size++;
        }



    }

    //删
    public E remove(int index) {
        //检查索引越界
        checkElementIndex(index);

        int cap = data.length;
        //判断是否需要缩容
        if (size == cap / 4) {
            resize(cap >> 2);
        }

        E deleteVal = data[index];
        //搬移数据
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }

        data[size - 1] = null;
        size--;
        return deleteVal;
    }

    //改
    public void update(int index, E e) {
        checkElementIndex(index);
        data[index] = e;
    }

    //查
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }
    //检查数组元素是否越界
    private boolean isElementIndex(int index) {
        return index >=0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    //检查位置是否合法
    private boolean isPositionIndex(int index) {
        return index >=0 && index <= size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        //添加五个元素
        for (int i = 0; i < 5; i++) {
            arr.add(i,i);
        }

        arr.remove(3);
        arr.add(0,100);
        arr.remove(arr.size-1);

        for (int i = 0; i < arr.size; i++) {
            System.out.println(arr.get(i));
        }
    }

}
