package leetcode.editor.implementation;

import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: MyLinearProbingHashMap
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/7/8 20:57
 * @Version 1.0
 */
public class MyLinearProbingHashMap<K, V> {
    //自定义内部类，模拟键值对
    private static class KVNode<K, V> {
        K key;
        V val;

        KVNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    //真正存储键值对的数组table,底层是KVNode数组
    private KVNode<K, V>[] table;
    //HashMap中的键值对的个数
    private int size;
    //初始容量
    private static final int INIT_CAP = 4;

    public MyLinearProbingHashMap() {
        this(INIT_CAP);
    }

    public MyLinearProbingHashMap(int initCapacity) {
        this.size = 0;
        //保证容量不为负数或0
        initCapacity = Math.max(initCapacity, 1);
        //初始化table数组
        table = (KVNode<K, V>[]) new KVNode[initCapacity];

    }

    // ****增/改****
    public void put(K key,V val) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        int index = getKeyIndex(key);
        //key存在
        if (table[index] != null) {
            table[index].val = val;
            return;
        }


        //key不存在
        table[index] = new KVNode<>(key,val);
        size++;

        //把负载因子设置为0.75,超过则扩容
        if ((size / table.length) >= 0.75) {
            resize(2 * table.length);
        }

    }

    // ****删除****
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        //如果负载因子小于0.125则进行缩容
        if ((size / table.length) <= 0.125) {
            resize(table.length / 4);
        }

        int index = getKeyIndex(key);
        //如果key不存在
        if (table[index] == null) {
            return;
        }

        //key存在,开始进行remove
        table[index] = null;
        size--;
        //保证连续性,将index后entry进行rehash(重新进行插入)
        index = (index + 1) % table.length;
        while (table[index] != null) {
            KVNode<K, V> entry = table[index];
            table[index] = null;
            size--;
            put(entry.key,entry.val);
            index = (index + 1) % table.length;
        }
    }
    // ****查****
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        int index = getKeyIndex(key);
        //如果key不存在,直接返回空
        if (table[index] == null) {
            return null;
        }
        return table[index].val;
    }
    // 返回所有的key(顺序不固定)
    public List<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        //遍历table数组,将每个entry的key取出来添加到List中
        for (KVNode<K,V> entry : table) {
            if (entry != null) {
                keys.addLast(entry.key);

            }
        }

        return keys;
    }

    // ****其他工具函数****
    public int size() {
        return this.size;
    }

    //哈希函数,将键映射到底层键值对数组的索引[0, table.length - 1]
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    //对key进行线性探查,返回一个索引. 如果key不存在,则返回的是第一个找到为null索引,可用于插入
    private int getKeyIndex(K key) {
        int index;
        for (index = hash(key); table[index] != null; index = (index + 1) % table.length) {
            if (key.equals(table[index].key)) {
                return index;
            }
        }
        return index;
    }

    private void resize(int newCapacity) {
        //确保新的容量始终大于等于1(否则计算hash值会出问题)
        newCapacity = Math.max(newCapacity, 1);

        //新构造一个
        MyLinearProbingHashMap<K, V> map = new MyLinearProbingHashMap<>(newCapacity);
        //对原table进行遍历
        for (KVNode<K, V> node : table) {
            if (node != null) {
                //对每一个node进行重新插入
                map.put(node.key,node.val);
            }

        }
        //替换底层数组
        table = map.table;
    }


    public static void main(String[] args) {
        MyLinearProbingHashMap<Integer, Integer> map = new MyLinearProbingHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(10, 10);
        map.put(20, 20);
        map.put(30, 30);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2
        System.out.println(map.get(20)); // 20

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(20);
        System.out.println(map.get(20)); // null
        System.out.println(map.get(30)); // 30
    }
}
