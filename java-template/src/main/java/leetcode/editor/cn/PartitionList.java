package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            //首先定义两个虚拟头节点
            //存放小于x的链表的虚拟头节点
            ListNode dummy1 = new ListNode(-1);
            //存放大于等于x的链表的虚拟头节点
            ListNode dummy2 = new ListNode(-1);
            // p1,p2指针负责生成结果链表
            ListNode p1 = dummy1, p2 = dummy2;
            // p负责遍历原链表，类似合成两个有序链表的逻辑
            ListNode p = head;
            while (p != null) {
                if (p.val >= x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }

                //断开原链表中的每个节点的next指针
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }

            //连接两个链表
            p1.next = dummy2.next;

            return dummy1.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        
    }
}