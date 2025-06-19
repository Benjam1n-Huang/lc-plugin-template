package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                int first = nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    int second = nums[j];
                    if (first + second == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
        
    }
}