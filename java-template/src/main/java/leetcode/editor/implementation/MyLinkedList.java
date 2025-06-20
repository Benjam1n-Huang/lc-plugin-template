package leetcode.editor.implementation;

import java.util.NoSuchElementException;

/**
 * ClassName: MyLinkedList
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/6/20 11:16
 * @Version 1.0
 */
public class MyLinkedList<E> {
    //虚拟头尾节点
    final private Node<E> head,tail;
    private int size;

    private static class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    // 构造函数初始化虚拟头尾节点
    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    //增
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        ///插入
        Node<E> temp = tail.prev;

        newNode.next = tail;
        tail.prev = newNode;

        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }


    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        //直接插入到头节点之前
        Node<E> temp = head.next;

        newNode.next = temp;
        temp.prev = newNode;

        head.next = newNode;
        newNode.prev = head;
        size++;

    }

    public void add(int index,E element) {
        //首先判断index的合法性
        checkPositionIndex(index);
        //首先找到index的节点
        Node<E> p = head.next;
        for (int i = 0;i < index; i++) {
            p = p.next;
        }
        //执行插入操作
        Node<E> temp = p.prev;
        Node<E> newNode = new Node<>(element);

        newNode.next = p;
        p.prev = newNode;

        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }

    //删
    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }

        //虚拟节点的存在使得我们不需要考虑空指针的问题
        //首先获取到倒数第一和倒数第二个结点
        Node<E> x = tail.prev;
        Node<E> temp = tail.prev.prev;

        temp.next = tail;
        tail.prev = temp;

        E val = x.val;
        x.next = null;
        x.prev = null;
        size--;

        return val;
    }

    public E removeFirst() {
        if (size() < 1) {
            throw new NoSuchElementException();
        }

        //首先获取到第一个和第二个结点
        Node<E> x = head.next;
        Node<E> temp = head.next.next;

        head.next = temp;
        temp.prev = head;

        E val = x.val;
        x.next = null;
        x.prev = null;
        size--;

        return val;
    }

    public E remove(int index) {
        checkElementIndex(index);
        //首先获取到index位置上的结点
        Node<E> node = getNode(index);
        //然后获取到前面的结点和后面的节点
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;
        //然后更改指针的连接顺序
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        //释放内存
        node.prev = null;
        node.next = null;
        size--;

        return node.val;
    }
    //改
    public E set(int index,E val) {
        checkElementIndex(index);

        //获取到对应索引位置的结点
        Node<E> node = getNode(index);
        E oldVal = node.val;

        node.val = val;
        return oldVal;

    }
    //查
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).val;
    }

    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    // 工具函数
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> getNode(int index) {
        checkElementIndex(index);
        //如果是前半部分的元素,则从前开始向后遍历
        if (index <= (size() / 2)) {
            Node<E> p = head.next;
            for (int i = 0;i < index;i++) {
                p = p.next;
            }
            return p;
        }else {
            //如果是后半部分的元素,则从后开始向前遍历
            Node<E> p = tail.prev;
            for (int i = size - 1; i >= index; i--) {
                p = p.prev;
            }
            return p;
        }

    }

    //检查元素是否越界
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

    private void display() {
        System.out.println("size = " + size);
        for (Node<E> p = head.next;p != tail;p = p.next) {
            System.out.print(p.val + " <-> ");
        }
        System.out.println("null");
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.add(2, 100);

        list.display();
        // size = 5
        // 0 <-> 1 <-> 100 <-> 2 -> 3 -> null
    }
}
