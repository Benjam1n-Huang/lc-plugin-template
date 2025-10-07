package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            //可以将原数组拆成三个链表
            //dummy1,dummy2,dummy3分别代表红、白、蓝链表
            ListNode dummyRed = new ListNode(-1);
            ListNode dummyWhite = new ListNode(-1);
            ListNode dummyBlue = new ListNode(-1);

            ListNode pRed = dummyRed, pWhite = dummyWhite, pBlue = dummyBlue;
            //装配链表
            for(int num : nums) {
                ListNode node = new ListNode(num);
                switch(node.val) {
                    case 0 -> {
                        pRed.next = node;
                        pRed = pRed.next;
                    }
                    case 1 -> {
                        pWhite.next = node;
                        pWhite = pWhite.next;
                    }
                    case 2 -> {
                        pBlue.next = node;
                        pBlue = pBlue.next;
                    }
                }
            }

            //将三个链表连接起来
            pWhite.next = dummyBlue.next;
            pRed.next = dummyWhite.next;

            //转化为数组
            ListNode p = dummyRed.next;
            for(int i = 0;i < nums.length;i++) {
                nums[i] = p.val;
                p = p.next;
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // put your test code here
        
    }
}