package leetcode.editor.cn;

import java.security.Key;
import java.util.*;
import leetcode.editor.common.*;

public class ContainsDuplicateIii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            //维护一个长度为indexDiff的窗口滑过整个数组
            int left = 0, right = 0;
            //判断窗口中是否存在两个不同元素之差小于valueDiff
            //使用到 TreeSet 利用二叉搜索树结构寻找「地板元素」和「天花板元素」的特性了。
            TreeSet<Integer> window = new TreeSet<>();

            while(right < nums.length) {
                //为了防止i==j,所以在扩大窗口之前先判断是否有符合题意的索引对（i,j）
                //查找略大于nums[right]的那个元素
                Integer ceiling = window.ceiling(nums[right]);
                if(ceiling != null && (long) ceiling - nums[right] <= valueDiff) {
                    return true;
                }

                //查找略小于nums[right]的那个元素
                Integer floor = window.floor(nums[right]);
                if(floor != null && (long) nums[right] - floor <= valueDiff) {
                    return true;
                }

                //扩大窗口
                window.add(nums[right]);
                right++;

                if(right - left > indexDiff) {
                    //缩小窗口
                    window.remove(nums[left]);
                    left++;
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        // put your test code here
        
    }
}