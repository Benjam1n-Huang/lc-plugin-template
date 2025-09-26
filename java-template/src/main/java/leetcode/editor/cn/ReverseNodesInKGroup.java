package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseNodesInKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null ) return null;
            //1.先反转以head开头的k个元素(这里可以复用之前的reverseN函数)
            //2.将k+1个节点作为head递归调用reverseKGroup函数
            //3.最后将两个过程结果拼接起来

            //区间[a,b)包含k个待翻转的元素
            ListNode a,b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                //不足k个,就不需要反转了
                if (b == null) return head;
                b = b.next;
            }

            //翻转前k个元素
            ListNode newHead = reverseN(a,k);
            //此时b指向下一组待翻转元素的头节点
            //递归翻转后将链表连接起来
            a.next = reverseKGroup(b,k);
            return newHead;
        }

        ListNode reverseN(ListNode head, int n) {
            if (head == null || head.next == null) return head;
            ListNode pre = null, cur = head, nxt = head.next;
            while (n > 0) {
                n--;
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }

            //此时cur指向第n+1个元素
            head.next = cur;
            //此时pre是翻转后的头节点
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here
        
    }
}