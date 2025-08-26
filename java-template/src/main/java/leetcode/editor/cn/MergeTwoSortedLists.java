package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //创建虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;

            //p1指向链表list1
            ListNode p1 = list1;
            //p2指向链表list2
            ListNode p2 = list2;

            while (p1 != null && p2 != null) {
                //比较两个链表上遍历指针对应的节点值的大小。然后哪一方小就将哪一方添加到结果链表上去
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                }else {
                    p.next = p1;
                    p1 = p1.next;
                }

                //p不断前进
                p = p.next;
            }

            //跳出循环时，肯定是某一个链表遍历完了
            if (p1 != null) {
                p.next = p1;
            }

            if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here

    }
}