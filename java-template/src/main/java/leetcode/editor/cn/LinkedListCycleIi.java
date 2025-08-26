package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast,slow;
            fast = slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }
            //如果链表无环，则返回null
            if (fast == null || fast.next == null) {
                return null;
            }

            //如果链表有环，则返回环起点的节点
            //慢指针重新指向头节点
            slow = head;
            //然后快慢指针同时走，当再次相遇时，就是环的起点
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here
        
    }
}