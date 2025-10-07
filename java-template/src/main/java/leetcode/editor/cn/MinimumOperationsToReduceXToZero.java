package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumOperationsToReduceXToZero {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            //题目让你从边缘删除掉和为 x 的元素，那剩下来的是什么？剩下来的是不是就是 nums 中的一个子数组？
            //让你尽可能少地从边缘删除元素说明什么？是不是就是说剩下来的这个子数组大小尽可能的大？
            //这道题等价于让你寻找 nums 中元素和为 sum(nums) - x 的最长子数组。
            int n = nums.length, sum = 0;
            for (int i = 0; i < n; i++) {
                //统计数组的和
                sum += nums[i];
            }
            //滑动窗口需要寻找的子数组目标和
            int target = sum - x;

            int left = 0, right = 0;
            //记录窗口内的所有元素和
            int windowSum = 0;
            //记录目标子数组的最大长度
            int maxLen = Integer.MIN_VALUE;
            //开始执行滑动窗口框架
            while (right < nums.length) {
                //扩大窗口
                windowSum += nums[right];
                right++;

                while (windowSum > target && left < right) {
                    //缩小窗口
                    windowSum -= nums[left];
                    left++;
                }

                //寻找目标子数组
                if (windowSum == target) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }

            //目标子数组的最大长度可以推导出需要删除的字符数量
            return maxLen == Integer.MIN_VALUE ? -1 : n  - maxLen;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
        // put your test code here
        solution.minOperations(new int[]{1,1,4,2,3},5);
    }
}