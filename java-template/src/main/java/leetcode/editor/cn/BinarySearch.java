package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinarySearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            //数组有序，可以使用二分查找
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else if(nums[mid] > target) {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // put your test code here
        
    }
}