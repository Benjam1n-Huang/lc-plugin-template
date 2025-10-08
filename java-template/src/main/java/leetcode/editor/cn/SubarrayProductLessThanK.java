package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SubarrayProductLessThanK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            //因为数组内的元素都是整数，所以扩大窗口的时候乘积一定变大，因此可以用滑动窗口
            //滑动窗口，维护一个窗口在nums上滑动，然后计算哪些元素之积小于k的窗口的个数即可
            int left = 0, right = 0;
            //滑动窗口内的乘积
            int windowProduct = 1;
            //记录满足条件的窗口的个数
            int count = 0;
            while(right < nums.length) {
                windowProduct = windowProduct * nums[right];
                right++;

                //当窗口内乘积大于等于k的时候，尝试缩小窗口
                while(windowProduct >= k && left < right) {
                    windowProduct = windowProduct / nums[left];
                    left++;
                }

                // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
                // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
                // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
                // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
                count += right - left;
            }

            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        // put your test code here
        
    }
}