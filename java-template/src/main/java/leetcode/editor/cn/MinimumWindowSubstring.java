package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //滑动窗口算法技巧主要用来解决子数组问题，比如让你寻找符合某个条件的最长/最短子数组
            // 记录 window 中的字符出现次数
            HashMap<Character, Integer> window = new HashMap<>();
            // 记录所需的字符出现次数
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c,0) + 1);
            }

            //滑动窗口的左右边界
            int left = 0, right = 0;
            //valid负责统计满足要求的字符数
            int valid = 0;
            //记录最小覆盖子串的起始索引和长度
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                //c是即将移入窗口的字符
                char c = s.charAt(right);
                //扩大窗口
                right++;
                //进行窗口内的一些列数据更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c,0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //判断左窗口是否要收缩
                while (valid == need.size()) {
                    //在这里更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    //d是即将移出窗口的字符
                    char d = s.charAt(left);
                    //缩小窗口
                    left++;
                    //进行窗口内的一系列数据更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }

            //返回最小覆盖子串
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here
        
    }
}