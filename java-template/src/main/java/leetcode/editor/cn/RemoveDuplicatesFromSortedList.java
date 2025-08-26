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
            //使用快慢指针的思想，慢指针slow在后面，fast指针在前面探路，当遇到了重复的节点，就将这个节点从链表中断开
            //当fast指针遍历到链表尾时，此时从索引0到索引slow的链表时非重复且有序的
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }

            //将slow后面的链表断开
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