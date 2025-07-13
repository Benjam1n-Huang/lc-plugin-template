package leetcode.editor.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * ClassName: MyArrayHashMap
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/7/10 10:26
 * @Version 1.0
 */
public class MyArrayHashMap<K,V> {
    private static class Node<K,V> {
        K key;
        V val;

        Node (K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    //存储 key和key在arr中的索引
    private final HashMap<K,Integer> map = new HashMap<>();

    //真正存储key-value的数组
    private final ArrayList<Node<K,V>> arr = new ArrayList<>();

    private final Random r = new Random();

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        //获取key在map中索引
        Integer index = map.get(key);
        return arr.get(index).val;
    }

    public void put(K key,V val) {
        if (!map.containsKey(key)) {
            Node<K, V> node = new Node<>(key, val);
            //将node插入到ArrayList中
            arr.add(node);
            map.put(key,arr.size() - 1);
            return;
        }

        Integer index = map.get(key);
        Node<K, V> node = arr.get(index);
        node.val = val;

    }

    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }
        Integer index = map.get(key);
        Node<K, V> node = arr.get(index);

        //1. 最后一个元素e和第index个元素node换位置
        Node<K, V> e = arr.get(arr.size() - 1);
        arr.set(index,e);
        arr.set(arr.size() - 1,node);

        //2. 修改map中e.key对应的索引
        map.put(e.key,index);

        //3. 在数组中删除最后一个元素
        arr.remove(arr.size() - 1);

        //4. 在map中删除node.key
        map.remove(node.key);
    }

    //随即弹出一个键
    private K randomKey() {
        int n = arr.size();
        int randomIndex = r.nextInt(n);
        return arr.get(randomIndex).key;
    }

    public static void main(String[] args) {
        MyArrayHashMap<Integer, Integer> map = new MyArrayHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);

        System.out.println(map.get(1)); // 1
        System.out.println(map.randomKey());

        map.remove(4);
        System.out.println(map.randomKey());
        System.out.println(map.randomKey());
    }
}
