package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class AddTwoNumbersIi {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //把链表元素转入栈中
            Stack<Integer> stk1 = new Stack<>();
            while (l1 != null) {
                stk1.push(l1.val);
                l1 = l1.next;
            }

            Stack<Integer> stk2 = new Stack<>();
            while (l2 != null) {
                stk2.push(l2.val);
                l2 = l2.next;
            }

            //虚拟头节点
            ListNode dummy = new ListNode(-1);

            //记录进位
            int carry = 0;
            //开始执行加法，两条链表走完且没有进位时才能结束循环
            while (!stk1.isEmpty() || !stk2.isEmpty() || carry > 0) {
                //先加上次的进位
                int val = carry;
                if (!stk1.isEmpty()) {
                    val += stk1.pop();
                }

                if (!stk2.isEmpty()) {
                    val += stk2.pop();
                }

                carry = val / 10;
                val = val % 10;
                ListNode node = new ListNode(val);
                //新节点直接跟在虚拟头节点后面
                node.next = dummy.next;
                dummy.next = node;
            }

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        // put your test code here
        
    }
}