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
            //最简单的思路,反转链表,然后逐个比对
            ListNode temp = head;
            ListNode newHead = reverse(temp);
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = null, cur = head, nxt = head.next;
            while (cur != null) {
                cur.next  = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }

            //此时pre指向翻转后链表的头节点
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        
    }
}