package leetcode.editor.implementation;

/**
 * ClassName: CycleArray
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/6/20 14:37
 * @Version 1.0
 */
public class CycleArray<T> {
    private T[] arr;
    private int start;
    private int end;
    private int count;
    private int size;

    public CycleArray() {
        this(1);
    }

    @SuppressWarnings("unchecked")
    public CycleArray(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
        //start 指向第一个有效元素的索引,闭区间
        this.start = 0;
        //end 指向最后一个有效元素的下一个位置,开区间
        this.end = 0;
        this.count = 0;
    }

    //自动扩容辅助函数
    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        //创建新的数组
        T[] newArr = (T[]) new Object[newSize];
        //将旧数组中的元素复制到新的数组中
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }
        arr = newArr;
        //重置start和end指针
        start = 0;
        end = count;
        size = newSize;
    }

    //在数组头部添加元素,时间复杂度O(1)
    public void addFirst(T val) {
        //当数组满了,扩容为原来的两倍
        if (isFull()) {
            resize(2 * size);
        }
        //开始添加,start尝试左移
        start = (start - 1 + size) % size;  //这个公式的目的是,当start处于数组的头时,此时为了满足逻辑上的循环数组,因此start指针要移动到数组尾部的位置,也就是size-1
        arr[start] = val;
        count++;
    }

    //删除数组头部元素,时间复杂度O(1)
    public void removeFirst() {
        //若数组为空,则返回null
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        //删除头部元素时,start指针尝试右移
        arr[start] = null;
        start = (start + 1) % size; //边界情况,start指针此时指向数组的最后一个位置size-1,且数组是满的,因此此时要移动到索引为0的位置
        count--;
        //如果数组元素数量减少到了原大小的四分之一,则减小数组大小为一半
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    //在数组尾部添加元素,时间复杂度O(1)
    public void addLast(T val) {
        //当数组满了,扩容为原来的两倍
        if (isFull()) {
            resize(2 * size);
        }
        //一定要记住,end是开区间,所以需要先赋值,然后再移动end指针
        arr[end] = val;
        end = (end + 1) % size;
        count++;
    }

    //删除数组尾部元素,时间复杂度O(1)
    public void removeLast() {
        //若数组为空,则返回null
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        //一定要记住,end是开区间,所以删除操作时先移动end指针,然后再赋值
        end = (end - 1 + size) % size;
        arr[end] = null;
        count--;
        //如果数组元素数量减少到了原大小的四分之一,则减小数组大小为一半
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    //获取数组头部元素,时间复杂度O(1)
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[start];
    }

    // 获取数组尾部元素，时间复杂度 O(1)
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[(end-1+size)%size];
    }

    public boolean isFull() {
        return size == count;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
