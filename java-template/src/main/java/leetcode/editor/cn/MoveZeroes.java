package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            //反向思考,将所有不为0的元素移到前面,然后将数组剩余的元素赋值为0就好了
            //快慢指针
            //fast在前面探路,然后找到了值不为0的元素,就赋值给slow索引对应的元素,然后slow++
            //维护了nums[0..slow-1]区间内的元素全不为0
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow]  = nums[fast];
                    slow++;
                }
                fast++;
            }
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        
    }
}