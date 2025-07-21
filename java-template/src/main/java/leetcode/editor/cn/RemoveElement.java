package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) return 0;
            int slow = 0, fast = 0;

            while (fast < nums.length) {
                //维护数组nums[0...slow]均为值不等于val的元素
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