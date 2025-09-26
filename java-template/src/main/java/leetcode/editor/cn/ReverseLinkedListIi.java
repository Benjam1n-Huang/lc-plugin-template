package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedListIi {

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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //迭代写法
            //当m=1时,方法退化为翻转链表前N个节点
            if (m == 1) return reverseN(head,n);

            //先找到第m-1个节点
            ListNode pre = head;
            for (int i = 1; i < m-1; i++) {
                pre = pre.next;
            }
            pre.next = reverseN(pre.next,n-m+1);

            return head;
        }

        ListNode reverseN(ListNode head, int n) {
            if (head == null || head.next == null) return head;

            ListNode pre = null, cur = head, nxt = head.next;
            while (n > 0) {
                n--;
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }

            //此时cur指向第n+1个节点,head是反转后的尾节点
            head.next = cur;
            //此时pre是反转后的头节点
            return pre;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here
        
    }
}