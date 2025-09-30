package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            //相当于是一个长链表的拆解，将其拆成三部分
            //先将数组变成链表
            ListNode dummy = new ListNode(-1);
            ListNode p4 = dummy;
            for (int num : nums) {
                ListNode node = new ListNode(num);
                p4.next = node;
                p4 = p4.next;
            }

            //dummy1,2,3分别存储0，1，2链表
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);
            ListNode dummy3 = new ListNode(-1);
            ListNode p1 = dummy1, p2 = dummy2, p3 = dummy3;
            ListNode head = dummy.next;
            ListNode p = head;
            while (p != null) {
                if (p.val == 0) {
                    ListNode node = new ListNode(p.val);
                    p1.next = node;
                    p1 = p1.next;
                } else if (p.val == 1) {
                    ListNode node = new ListNode(p.val);
                    p2.next = node;
                    p2 = p2.next;
                } else if (p.val == 2) {
                    ListNode node = new ListNode(p.val);
                    p3.next = node;
                    p3 = p3.next;
                }

                //p前进
                p = p.next;
            }

            //将三个链表链接起来
            p2.next = dummy3.next;
            p1.next = dummy2.next;

            //将链表转化为数组
            int index = 0;
            ListNode temp  = dummy1.next;
            while (temp != null && index < nums.length) {
                nums[index] = temp.val;
                index++;
                temp = temp.next;
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // put your test code here
        
    }
}