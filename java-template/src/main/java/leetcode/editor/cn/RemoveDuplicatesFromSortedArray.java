package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            //使用双指针的技巧，slow指针走在后面，fast指针走在前面探路，当找到一个不重复的元素就赋值给slow并让slow前进一步。
            // 这样当fast遍历完整个数组后，nums[0...slow]就是整个数组去重之后的结果
            if (nums.length == 0) {
                return 0;
            }
            int slow = 0,fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    //维护nums[0...slow]无重复
                    nums[slow] = nums[fast];
                }
                fast++;
            }

            //数组长度为索引+1
            return slow + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        
    }
}