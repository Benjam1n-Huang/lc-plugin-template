package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaxConsecutiveOnesIii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            //滑动窗口，维护一个窗口在nums上滑动，保证证 nums 中的所有数字都被替换成 1，那么窗口可以达到的最大长度就是题目要的答案。
            int left = 0, right = 0;
            //记录窗口中1的出现次数
            int windowOneCount = 0;
            //记录结果长度
            int res = 0;

            while(right < nums.length) {
                //扩大窗口
                if(nums[right] == 1) {
                    windowOneCount++;
                }
                right++;

                while(right - left - windowOneCount > k) {
                    //当窗口中需要替换的0的数量大于k，尝试缩小窗口
                    if(nums[left] == 1) {
                        windowOneCount--;
                    }

                    left++;
                }

                //此时一定是一个合法的窗口，求窗口最大长度
                res = Math.max(res, right - left);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        // put your test code here
        
    }
}