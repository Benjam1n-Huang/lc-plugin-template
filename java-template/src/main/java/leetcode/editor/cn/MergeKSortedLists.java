package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeKSortedLists {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            //合并k个有序链表的本质和合并两个链表的逻辑是相同的
            //问题的难点在于如何快速在k个节点中找到最小/最大的节点
            //首先创建虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;

            //创建优先级队列（小顶堆）
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    lists.length, (a, b)->(a.val - b.val));
            //将每个链表的头节点插入到小顶堆中
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head);
                }

            }

            //当小顶堆不为空时就一直进行循环
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();  //从小顶堆中取出堆顶元素
                //插入到结果链表中
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }
                //p指针前移一位
                p = p.next;
            }

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        
    }
}