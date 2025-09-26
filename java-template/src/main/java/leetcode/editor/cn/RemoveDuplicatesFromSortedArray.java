package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            //快慢指针
            //让fast在前面探路,找到一个不重复的元素就赋值给slow,然后让slow前进一步
            //这样就保证了nums[0...slow]都是无重复的元素
            if (nums.length == 0) return 0;
            int slow, fast;
            slow = fast = 0;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    slow++;
                    //维护nums[0...slow]无重复
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