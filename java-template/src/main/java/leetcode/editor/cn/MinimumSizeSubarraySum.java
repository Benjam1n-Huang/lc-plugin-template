package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //当窗口内的元素和 < target时，扩大窗口来寻找可行解
            //当窗口内的元素和 >= target时，尝试缩小窗口寻找最优解
            //当窗口内的元素和 >= target时,更新最小子数组的长度
            int left = 0, right = 0;
            //记录窗口内的元素和
            int windowSum = 0;
            //记录最小子数组的长度
            int len = Integer.MAX_VALUE;

            //滑动窗口代码模板
            while(right < nums.length) {
                windowSum += nums[right];
                right++;

                while(windowSum >= target && left < right) {
                    //更新最小子数组的长度
                    len = Math.min(len, right - left);
                    //尝试缩小窗口
                    windowSum -= nums[left];
                    left++;
                }
            }

            return len == Integer.MAX_VALUE ? 0 : len;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // put your test code here
        
    }
}