package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    //维护nums[0...slow]无重复元素
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        
    }
}