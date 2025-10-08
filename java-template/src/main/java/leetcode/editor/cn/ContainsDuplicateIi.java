package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ContainsDuplicateIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            //维护一个大小为 k 的滑动窗口滑过整个数组，滑动的过程中计算窗口中是否存在重复元素。
            int left = 0, right = 0;
            HashSet<Integer> window = new HashSet<>();

            while(right < nums.length) {
                //扩大窗口
                if(window.contains(nums[right])) {
                    return true;
                }

                window.add(nums[right]);
                right++;

                if(right - left > k) {
                    //当窗口的大小大于k时，缩小窗口
                    window.remove(nums[left]);
                    left++;
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        // put your test code here
        
    }
}