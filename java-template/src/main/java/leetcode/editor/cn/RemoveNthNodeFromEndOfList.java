package leetcode.editor.cn;

import java.security.Key;
import java.util.*;

import leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 虚拟头结点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
            ListNode x = findFromEnd(dummy, n + 1);
            // 删掉倒数第 n 个节点
            x.next = x.next.next;
            return dummy.next;
        }

        private ListNode findFromEnd(ListNode head,int k) {
            ListNode p1 = head;
            //先让p1走k步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            //然后让p2指向链表头
            ListNode p2 = head;
            //让p1和p2同时走，当p1走到链表结尾时走了n-k步，此时刚好p2指向第n-k+1个节点(即倒数第k个节点)
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p2;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here

    }
}