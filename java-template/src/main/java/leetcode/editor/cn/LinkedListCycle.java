package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LinkedListCycle {

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
        public boolean hasCycle(ListNode head) {
            //快慢指针即可，fast指针走两步，slow指针走一步
            //当fast和slow再次相遇的时候就意味着链表存在环
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        // put your test code here
        
    }
}