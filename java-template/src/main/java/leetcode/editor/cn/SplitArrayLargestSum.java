package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SplitArrayLargestSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {
            //问题看似很复杂，其实转化一下就能想明白了
            //将问题转化为：你只有一艘货船，现在有若干货物，每个货物的重量是 nums[i]，现在你需要在 m 天内将这些货物运走，请问你的货船的最小载重是多少？
            //货船每天运走的货物就是nums的一个子数组
            //在m天之内运完就是将nums划分为m个子数组
            //让货船的运载能力尽可能小，就是让所有子数组中最大的哪个子数组的元素之和尽可能小

            int left = Arrays.stream(nums).max().getAsInt();
            int right = Arrays.stream(nums).sum();

            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(f(nums,mid) > k) {
                    //最小运载能力不足，导致无法在k天内运完所有货物，尝试扩大左边界（提升最小运载能力）
                    left = mid + 1;
                } else if(f(nums,mid) < k) {
                    //最小运载能力足够，可以在k天内运完所有货物，尝试缩小右边界（降低最小运载能力）
                    right = mid - 1;
                } else if(f(nums,mid) == k) {
                    //最小运载能力足够，可以在k天内运完所有货物，尝试缩小右边界（降低最小运载能力）
                    right = mid - 1;
                }
            }

            return left;

        }

        private long f(int[] nums, int x) {
            long days = 0;
            for (int i = 0; i < nums.length;) {
                int cap = x;
                while (i < nums.length) {
                    if(cap < nums[i]) break;
                    else cap -= nums[i];
                    i++;
                }
                days++;
            }
            return days;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
        // put your test code here
        
    }
}