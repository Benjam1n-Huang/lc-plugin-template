package leetcode.editor.cn;

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
            //虚拟头节点
            ListNode dummy = new ListNode(-1);

            dummy.next = head;
            //删除倒数第n个，要先找到倒数第n+1个
            ListNode x = findFromEnd(dummy, n + 1);
            //删掉倒数第n个节点
            x.next = x.next.next;
            return dummy.next;

        }

        private ListNode findFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            //p1先走k步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }

            ListNode p2 = head;
            //p1和p2同时走n-k步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }

            //p2现在指向第n-k+1个节点，即倒数第k个节点
            return p2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here

    }
}