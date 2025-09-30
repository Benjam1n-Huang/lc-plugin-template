package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PalindromeLinkedList {

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
        public boolean isPalindrome(ListNode head) {
            //最简单的思路,反转链表，然后比对
            //首先复制一条原链表
            ListNode dummy = new ListNode(-1);
            ListNode p1 = dummy;
            ListNode p2 = head;
            while (p2 != null) {
                ListNode node = new ListNode(p2.val);
                p1.next = node;
                p1 = p1.next;
                p2 = p2.next;
            }
            ListNode p3 = dummy.next;
            //反转原先的链表，返回反转后的头节点
            ListNode p4 = reverse(head);

            //开始比对
            while (p3 != null && p4 != null) {
                if (p3.val != p4.val) {
                    return false;
                }else {
                    p3 = p3.next;
                    p4 = p4.next;
                }
            }

            return true;

        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = null, cur = head, nxt = head.next;
            while (cur != null) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }

            return pre;
         }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        
    }
}