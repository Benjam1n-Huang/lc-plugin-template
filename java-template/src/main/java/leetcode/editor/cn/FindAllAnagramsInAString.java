package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindAllAnagramsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String t) {
            //这道题本质上还是使用滑动窗口先找到最小覆盖子串,然后判断这个最小覆盖字串的长度和s的长度是否相等
            //如果相等,则表明这个最小覆盖字串是s的排列之一,此时将这个最小覆盖字串的起始索引start添加到res链表中
            //window来统计滑动窗口内的字符统计情况
            HashMap<Character, Integer> window = new HashMap<>();
            //need来统计需求的字符统计情况
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c,0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;
            //记录结果
            List<Integer> res = new ArrayList<>();
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                //进行窗口内的一些列数据更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //判断左侧窗口是否要收缩
                while (right - left >= t.length()) {
                    //当窗口符合条件时,把起始索引加入res
                    if (valid == need.size()) {
                        res.add(left);
                    }

                    char d = s.charAt(left);
                    left++;
                    //进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }

            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here
        
    }
}