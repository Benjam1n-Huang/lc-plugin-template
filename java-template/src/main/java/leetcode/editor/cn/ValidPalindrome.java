package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidPalindrome {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            //先对原有的字符串进行清理，使其只包含小写字符和数字
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }

            //清理之后的字符串
            s = sb.toString();
            //进行回文串比较 - 滑动窗口
            int left = 0, right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        // put your test code here
        
    }
}