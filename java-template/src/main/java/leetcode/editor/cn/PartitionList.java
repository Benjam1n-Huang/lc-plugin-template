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
            //分解链表，首先创建两个虚拟头节点
            //链表1维护小于x的节点
            ListNode dummy1 = new ListNode(101);
            //链表2维护大于等于x的节点
            ListNode dummy2 = new ListNode(101);

            ListNode p1 = dummy1, p2 = dummy2;
            //指针p在链表上游走
            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    p1.next = p;
                    p1 = p1.next;
                }else {
                    p2.next = p;
                    p2 = p2.next;
                }

                //将节点从原始链表中断开避免成环
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }

            //将dummy1和dummy2分别维护的链表连接起来
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