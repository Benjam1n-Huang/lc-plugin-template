package leetcode.editor.implementation;

import java.util.LinkedList;

/**
 * ClassName: MyLinkedQueue
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/6/20 18:27
 * @Version 1.0
 */
public class MyLinkedQueue<E> {
    private final LinkedList<E> list = new LinkedList<>();

    //向队尾插入元素，，时间复杂度O(1)
    public void push(E e) {
        list.addLast(e);
    }

    //从队头删除元素，时间复杂度O(1)
    public E pop() {
        return list.removeFirst();
    }

    //查看队头元素，时间复杂度O(1)
    public E peek() {
        return list.getFirst();
    }

    //返回队列中的元素个数，时间复杂度O(1)
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        System.out.println(queue.pop()); // 2
        System.out.println(queue.peek()); // 3
    }

}
