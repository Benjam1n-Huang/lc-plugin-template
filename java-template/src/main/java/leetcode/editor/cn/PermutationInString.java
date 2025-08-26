package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PermutationInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            //使用滑动窗口来找到最小覆盖子串
            //本体的难点在于：判断s1的排列组合是s2的子串。 我能想到的方法是，判断最小覆盖子串和s1的长度是否相等，因为s1的排列虽然字符顺序变了，但是长度没变
            //window来统计滑动窗口内的字符统计情况
            HashMap<Character, Integer> window = new HashMap<>();
            //need来统计需求的字符统计情况
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c,0) + 1);
            }

            //记录最小覆盖字串的起始索引和长度
            int start = 0, len = Integer.MAX_VALUE;

            //滑动窗口左右指针
            int left = 0, right = 0;
            int valid = 0;
            while (right < s2.length()) {
                //c 是即将进入窗口的字符
                char c = s2.charAt(right);
                //窗口扩大
                right++;
                //滑动窗口扩大之后，开始进行窗口内的数据处理
                if (need.containsKey(c)) { //表示即将添加到窗口内的字符是需求字符之一
                    window.put(c,window.getOrDefault(c,0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //窗口开始缩小的条件
                while (valid == need.size()) {
                    //更新最小覆盖子串的情况
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    //d 是即将移出窗口的字符
                    char d = s2.charAt(left);
                    //缩小窗口
                    left++;
                    //滑动窗口缩小,开始进行窗口内的数据处理
                    if (need.containsKey(d)) { //表示即将移出窗口内的字符是需求字符之一
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d,window.getOrDefault(d,0) - 1);
                    }
                }
            }

            //现在得到了最小覆盖子串的起始索引start和长度len
            if (len == s1.length()) {
                return true;
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here
        
    }
}