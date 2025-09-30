package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m++] = nums2[i];
            }
            //对nums1进行排序
            Arrays.sort(nums1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        // put your test code here
        
    }
}