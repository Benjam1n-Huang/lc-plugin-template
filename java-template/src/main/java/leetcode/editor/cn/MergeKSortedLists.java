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
            //合并k个有序链表为一个升序链表的逻辑类似于合并两个有序链表，难点在于快速找到k个节点中的最小节点
            if (lists.length == 0) {
                return null;
            }

            //虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            //优先级队列，最小堆
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    lists.length, (a, b) -> (a.val - b.val));

            //将k个链表的头节点加入最小堆
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head);
                }
            }

            while (!pq.isEmpty()) {
                //获取最小节点，接到结果链表中
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }

                //p指针不断地前进
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