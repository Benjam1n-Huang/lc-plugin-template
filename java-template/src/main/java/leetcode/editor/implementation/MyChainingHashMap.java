package leetcode.editor.implementation;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: MyChainingHashMap
 * Package: leetcode.editor.implementation
 * Description:
 *
 * @Author Benjamin-Huang
 * @Create 2025/6/20 21:18
 * @Version 1.0
 */
public class MyChainingHashMap<K,V> {
    //拉链法使用的单链表结点，存储key-value对
    private static class KVNode<K,V>{
        K key;
        V value;

        KVNode(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }

    //哈希表的底层数组，每个数组元素是一个链表，链表中的每个节点是KVNode存储键值对
    private LinkedList<KVNode<K,V>>[] table;

    //哈希表存入的键值对的个数
    private int size;
    //底层数组的初始容量
    private static final int INIT_CAP = 4;

    public MyChainingHashMap() {
        this(INIT_CAP);
    }

    public MyChainingHashMap(int initCapacity) {
        size = 0;
        //保证底层数组的容量至少为1，因为hash函数中有取模运算,避免出现除以0的情况出现
        initCapacity = Math.max(initCapacity,1);
        //初始化哈希表
        table = (LinkedList<KVNode<K,V>>[]) new LinkedList[initCapacity];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // ******** 增/改 ********
    //添加key-value对
    //如果键key已经存在，则修改对应的value值
    public void put(K key,V value) {
        //首先判断key的合法性
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        //找到对应索引位置上的list
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        //遍历这个list
        for (KVNode<K,V> node : list) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        list.add(new KVNode<>(key,value));
        size++;

        //如果元素的数量超过了负载因子,则进行扩容
        if (size/ table.length >= 0.75) {
            resize(table.length * 2);
        }

    }

    // ******** 删 ********
    //删除key和对应的value
    public void remove(K key) {
        //首先判断key的合法性
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        //找到对应索引位置上的list
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        //遍历这个list
        for (KVNode<K,V> node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
                size--;

                //当负载因子小于0.125时,进行缩容处理
                if (size / table.length < 0.125) {
                    resize(table.length / 4);
                }
                return;
            }
        }
    }

    // ******** 查 ********
    // 返回 key 对应的 val，如果 key 不存在，则返回 null
    public V get(K key) {
        //首先判断key的合法性
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        //找到对应索引位置上的list
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        //遍历这个list
        for (KVNode<K,V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    //返回所有的key
    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K,V>> list : table) {
            for (KVNode<K,V> node : list) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    // ******** 工具函数 ********
    public int size() {
        return size;
    }

    //哈希函数，将键映射到table的索引上
    private int hash(K key) {
        return (key.hashCode() & 0x7ffffff) % table.length;
    }

    private void resize(int newCap) {
        //首先构造一个新的HashMap
        //避免newCap为0，造成求模运算出现取模异常
        newCap = Math.max(newCap,1);
        MyChainingHashMap<K, V> newMap = new MyChainingHashMap<>(newCap);
        //穷举当前HashMap中的所有键值对
        for (LinkedList<KVNode<K,V>> list : table) {
            for (KVNode<K,V> node : list) {
                //进行数据搬移
                newMap.put(node.key, node.value);
            }
        }
        //将当前HashMap的底层table换掉
        table = newMap.table;
    }

    public static void main(String[] args) {
        MyChainingHashMap<Integer, Integer> map = new MyChainingHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(2);
        System.out.println(map.get(2)); // null
        // [1, 3]（顺序可能不同）
        System.out.println(map.keys());

        map.remove(1);
        map.remove(2);
        map.remove(3);
        System.out.println(map.get(1)); // null
    }
}
