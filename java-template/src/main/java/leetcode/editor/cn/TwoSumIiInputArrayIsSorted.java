package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSumIiInputArrayIsSorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //左右指针
            int left = 0,right = numbers.length-1;
            while (left < right) {
                if ((numbers[left] + numbers[right]) == target) {
                    return new int[]{left + 1,right + 1};
                }else if ((numbers[left] + numbers[right]) < target) {
                    left++;
                }else if ((numbers[left] + numbers[right]) > target) {
                    right--;
                }
            }

            return null;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here
        
    }
}