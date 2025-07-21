package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSumIiInputArrayIsSorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //一左一右两个指针相向而行
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    // 题目要求的索引是从 1 开始的
                    return new int[]{left + 1, right + 1};
                } else if (sum < target) {
                    // 让 sum 大一点
                    left++;
                } else if (sum > target) {
                    // 让 sum 小一点
                    right--;
                }
            }

            return new int[]{-1,-1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here
        
    }
}