package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //滑动窗口来解决最小覆盖子串的问题
            //window来记录窗口内的字符统计情况
            HashMap<Character, Integer> window = new HashMap<>();
            //need来记录需求的字符统计情况
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c,need.getOrDefault(c,0) + 1);
            }

            //记录最小覆盖子串的起始索引和长度
            int start = 0, len = Integer.MAX_VALUE;

            //滑动窗口
            int left = 0, right = 0;
            int valid = 0;
            while (right < s.length()) {
                //c 是即将加入到窗口的字符
                char c = s.charAt(right);
                //扩大窗口
                right++;
                //窗口内添加新字符后，开始进行数据处理
                if (need.containsKey(c)) { //表示即将添加到窗口window内的字符是我们的目标字符之一
                    window.put(c,window.getOrDefault(c,0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //窗口开始收缩的条件
                while (valid == need.size()) {
                    //更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    //d 是即将移出窗口的字符
                    char d = s.charAt(left);
                    //窗口左边界收缩
                    left++;

                    //滑动窗口收缩，开始对窗口内的数据进行处理
                    if (need.containsKey(d)) { //表示即将移出窗口的字符是目标字符之一
                        if (window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d,window.get(d) - 1);
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