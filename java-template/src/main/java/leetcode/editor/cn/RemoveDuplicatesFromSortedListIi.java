package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedListIi {

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            //没有重复节点的结果链表
            ListNode dummyUniq = new ListNode(-101);
            //重复节点的结果链表
            ListNode dummyDup = new ListNode(-101);
            ListNode pUniq = dummyUniq, pDup = dummyDup;
            //p来遍历链表
            ListNode p = head;
            while (p != null) {
                if ((p.next !=null && p.val == p.next.val) || p.val == pDup.val) {
                    pDup.next = p;
                    pDup = pDup.next;
                }else {
                    pUniq.next = p;
                    pUniq = pUniq.next;
                }

                p = p.next;
                pDup.next = null;
                pUniq.next = null;
            }
            return dummyUniq.next;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here
        ListNode listNode = ListNode.createHead(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode resultListNode = solution.deleteDuplicates(listNode);
        ListNode.print(resultListNode);

    }
}