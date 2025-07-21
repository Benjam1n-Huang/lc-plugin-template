package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedListIi {

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
        public ListNode deleteDuplicates(ListNode head) {
            //使用链表分解的做法
            //将原链表分解为两条链表
            //一条链表存放不重复的节点，另一条链表存放重复的节点
            //运用虚拟头节点的技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
            ListNode dummyUniq = new ListNode(101);
            ListNode dummyDup = new ListNode(101);

            ListNode pUniq = dummyUniq,pDup = dummyDup;
            ListNode p = head;

            while (p != null) {
                if ((p.next != null && p.val == p.next.val) || p.val == pDup.val) {
                    //发现重复节点，接到重复链表后面
                    pDup.next = p;
                    pDup = pDup.next;
                } else {
                    //不是重复节点，接到不重复链表后面
                    pUniq.next = p;
                    pUniq = pUniq.next;
                }

                p = p.next;
                //将原链表和新链表断开
                pUniq.next = null;
                pDup.next = null;
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