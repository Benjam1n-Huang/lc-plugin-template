package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SquaresOfASortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i] * nums[i];
            }
            //排序
            Arrays.sort(res);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // put your test code here
        
    }
}