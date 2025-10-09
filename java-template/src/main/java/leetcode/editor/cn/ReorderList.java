package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReorderList {

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
        public void reorderList(ListNode head) {
            //利用栈的LIFO，按从头到尾的顺序让链表节点入栈
            Stack<ListNode> stk = new Stack<>();
            //先把所有的链表节点装进栈里，得到倒叙结果
            ListNode p = head;
            while(p != null) {
                stk.push(p);
                p = p.next;
            }

            p = head;
            while(p != null) {
                //链表的尾部节点
                ListNode lastNode = stk.pop();
                ListNode next = p.next;
                if(lastNode == next || lastNode.next == next) {
                    //结束条件，链表节点为奇数或者偶数时均适用
                    lastNode.next = null;
                    break;
                }

                //将lastNode插入到p和p.next之间
                p.next = lastNode;
                lastNode.next = next;
                p = next;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        // put your test code here
        
    }
}