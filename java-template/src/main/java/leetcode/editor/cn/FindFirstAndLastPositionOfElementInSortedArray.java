package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import leetcode.editor.common.*;

public class FindFirstAndLastPositionOfElementInSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //问题可以转化为寻找target在数组中的左边界和右边界
            return new int[]{left_bound(nums,target),right_bound(nums,target)};
        }

        /**
         * 寻找target出现的左边界
         * @param nums
         * @param target
         * @return
         */
        private int left_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] < target) {
                    left = mid + 1;
                }else if(nums[mid] > target) {
                    right = mid - 1;
                }else if(nums[mid] == target) {
                    //此时定位到了target出现的位置
                    //right = mid - 1的意思就是不断尝试缩小搜索区间的右边界，最终定位左边界
                    right = mid - 1;
                }
            }

            //如果target值比nums中所有的元素都大，最终left跳出循环时为right + 1也就是nums.length
            if(left < 0 || left >= nums.length) {
                return -1;
            }

            return nums[left] == target ? left : -1;
        }

        /**
         * 寻找target出现的右边界
         * @param nums
         * @param target
         * @return
         */
        private int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] < target) {
                    left = mid + 1;
                }else if(nums[mid] > target) {
                    right = mid - 1;
                }else if(nums[mid] == target) {
                    //此时定位到了target出现的位置
                    //left = mid + 1的意思就是不断尝试扩大搜索区间的左边界，最终定位右边界
                    left = mid + 1;
                }
            }

            // 由于 while 的结束条件是 right == left - 1，且现在在求右边界
            // 所以用 right 替代 left - 1 更好记
            if (right < 0 || right >= nums.length) {
                return -1;
            }

            return nums[right] == target ? right : -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // put your test code here
        
    }
}