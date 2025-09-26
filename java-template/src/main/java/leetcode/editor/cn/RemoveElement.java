package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            //快慢指针
            //fast在前面探路,然后如果找到了值不为val的元素,就让赋值给slow,然后让slow++
            //维护了nums[0...slow-1]区间内值都不为val
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }

            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        
    }
}