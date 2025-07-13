package leetcode.editor.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ClassName: MyLinkedHashMap
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/7/10 9:48
 * @Version 1.0
 */
public class MyLinkedHashMap<K,V> {

    private static class Node<K,V> {
        K key;
        V val;
        Node<K,V> prev,next;



        Node (K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Node<K,V> head,tail;

    private final HashMap<K,Node<K,V>> map = new HashMap<>();

    MyLinkedHashMap () {
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);

        if (node != null) {
            return node.val;
        }
        return null;
    }

    public void put(K key, V val) {
        //插入新节点的时候，同时插入链表和map
        if (!map.containsKey(key)) {
            Node<K, V> node = new Node<>(key, val);
            addLastNode(node);
            map.put(key,node);
        }
        //若存在，则替换之前的val
        map.get(key).val = val;
    }

    public void remove(K key) {
        // 若 key 本不存在，直接返回
        if (!map.containsKey(key)) {
            return;
        }
        // 若 key 存在，则需要同时在哈希表和链表中删除
        Node<K, V> node = map.get(key);
        map.remove(key);
        removeNode(node);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (Node<K, V> p = head.next; p != tail; p = p.next) {
            keyList.add(p.key);
        }
        return keyList;
    }

    public int size() {
        return map.size();
    }



    public void addLastNode(Node<K,V> x) {
        Node<K, V> temp = tail.prev;

        //将x结点插入到tail结点之前
        x.next = tail;
        tail.prev = x;

        x.prev = temp;
        temp.next = x;
    }

    private void removeNode(Node<K,V> x) {
        Node<K, V> prev = x.prev;
        Node<K, V> next = x.next;

        prev.next = next;
        next.prev = prev;

        x.next = x.prev = null;
    }

    public static void main(String[] args) {
        MyLinkedHashMap<String, Integer> map = new MyLinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        System.out.println(map.keys()); // [a, b, c, d, e]
        map.remove("c");
        System.out.println(map.keys()); // [a, b, d, e]
    }
}
