package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //p1指向A链表头节点，p2指向B链表头节点
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                //p1走一步，如果走到A链表末尾，则转到B链表
                if (p1 == null) p1 = headB;
                else p1 = p1.next;

                //p2走一步，如果走到B链表末尾，则转到A链表
                if (p2 == null) p2 = headA;
                else p2 = p2.next;
            }

            return p1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here
        
    }
}