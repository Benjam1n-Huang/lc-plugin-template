package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedList {

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
            if (head == null) return null;
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = slow.next;
                }

                fast = fast.next;
            }

            //断开与后面重复元素的连接
            slow.next = null;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        // put your test code here
        
    }
}