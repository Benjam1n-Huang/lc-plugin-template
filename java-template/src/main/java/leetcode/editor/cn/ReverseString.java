package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int left = 0,right = s.length - 1;
            while (left <= right) {
                //交换left和right对应索引位置上的元素
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;

                //然后让left++，right--
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // put your test code here
        
    }
}