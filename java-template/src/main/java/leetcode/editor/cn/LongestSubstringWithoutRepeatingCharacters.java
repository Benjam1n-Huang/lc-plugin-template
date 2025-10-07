package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            //统计窗口中各个字符出现的次数
            HashMap<Character, Integer> window = new HashMap<>();
            //窗口的左右边界
            int left = 0, right = 0;
            int res = 0;
            while (right < s.length()) {
                //c是即将移入窗口的字符
                char c = s.charAt(right);
                //窗口扩大
                right++;
                //进行窗口中的数据更新
                window.put(c, window.getOrDefault(c,0) + 1);
                //判断左窗口是否要进行收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    //进行窗口内的一系列数据更新
                    window.put(d, window.get(d) - 1);
                }
                
                //更新答案
                res = Math.max(res, right - left);
            }


            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here
        
    }
}