package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
            //反转以head为起点的单链表
            if (head == null || head.next == null) {
                return head;
            }
            // 由于单链表的结构，至少要用三个指针才能完成迭代反转
            // cur 是当前遍历的节点，pre 是 cur 的前驱结点，nxt 是 cur 的后继结点
            ListNode pre,cur,nxt;
            pre = null; cur = head; nxt = head.next;
            while (cur != null) {
                //逐个节点反转
                cur.next = pre;
                //更新指针位置
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }

            //返回反转后的头节点
            return pre;


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        
    }
}