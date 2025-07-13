package leetcode.editor.implementation;

import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * ClassName: MyPriorityQueue
 * Package: leetcode.editor.implementation
 * Description:
 * 优先队列
 * @Author Benjamin-Huang
 * @Create 2025/7/11 17:20
 * @Version 1.0
 */
public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
        heap = (T[]) new Object[capacity];
        size = 0;
        this.comparator = comparator;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //父节点的索引
    public int parent(int node) {
        return (node - 1) / 2;
    }

    //左孩子的索引
    public int left(int node) {
        return node * 2 + 1;
    }

    //右孩子的索引
    public int right(int node) {
        return node * 2 + 2;
    }

    //交换数组的两个元素
    public void swap(int i,int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //查：返回堆顶元素，时间复杂度O(1)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is Empty");
        }
        return heap[0];
    }

    //增：向堆中插入一个元素，时间复杂度O(1)
    public void push(T x) {
        //扩容
        if (size == heap.length) {
            resize(2 * heap.length);
        }

        //把新元素添加到最后（也就是最底层的最右边叶子节点）
        heap[size] = x;
        //然后上浮到正确的位置
        swim(size);
        size++;

    }

    //删,删除堆顶元素,时间复杂度O(1)
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }

        T res = heap[0];
        //把堆底元素放到堆顶
        swap(0,size-1);
        //避免对象游离
        heap[size - 1] = null;
        size--;
        //然后下沉到正确的位置
        sink(0);
        //缩容
        if ((size > 0) && (size == heap.length / 4)) {
            resize(heap.length / 2);
        }
        return res;
    }

    //上浮操作,时间复杂度是树高O(logN)
    //每次新增的结点都是添加到了数组的末尾(逻辑上就是二叉树的最底层的最右边结点)
    //然后开始获取父节点的索引,如果父节点比它大,则交换他们的位置
    //然后将父节点的索引重新赋值给node,开始下一轮的循环,一直上浮到父节点的值比它小为止
    private void swim(int node) {
        while (node > 0 && comparator.compare(heap[parent(node)],heap[node]) > 0) {
            swap(parent(node),node);
            node = parent(node);
        }
    }

    //下沉操作,时间复杂度是树高O(logN)
    private void sink(int node) {
        while (left(node) < size || right(node) < size) {
            int min = node;
            //比较自己和左右结点,看看谁最小
            if (left(node) < size && comparator.compare(heap[left(node)],heap[min]) < 0) {
                min = left(node);
            }
            if (right(node) < size && comparator.compare(heap[right(node)], heap[min]) < 0) {
                min = right(node);
            }
            if (min == node) {
                break;
            }

            //如果左右节点之中有比自己小的,就交换
            swap(node,min);
            node = min;
        }
    }


    //调整堆的大小
    public void resize(int capacity) {
        assert capacity > size;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(3, Comparator.naturalOrder());
        pq.push(3);
        pq.push(1);
        pq.push(4);
        pq.push(1);
        pq.push(5);
        pq.push(9);
        // 1 1 3 4 5 9
        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}
