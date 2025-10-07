package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PermutationInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            //滑动窗口算法适合解决最小子数组\最小字串的问题
            //问题的解决思路是构造两个HashMap,一个用来统计s1中每个字符串出现的次数,另一个用来统计滑动窗口中字符的出现次数
            //如果最终二者相等,且最小子串的长度和s1的长度也相等,那么就返回true,否则返回false
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c,0) + 1);
            }

            //滑动窗口的左右边界
            int left = 0, right = 0;
            //valid用来统计满足要求的字符数
            int valid = 0;
            //start记录最小子串的起始索引,len负责记录最小子串的长度
            int start = 0, len = Integer.MAX_VALUE;

            //窗口扩大是负责找可行解,窗口收缩是负责优化可行解
            while (right < s2.length()) {
                //c是即将要移入窗口的字符
                char c = s2.charAt(right);
                //窗口扩大
                right++;
                //进行一些列的数据更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c,0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //如果满足要求的字符数量足够了,就要开始优化这个可行解,也就是窗口收缩
                while (valid == need.size()) {
                    if (right - left < len) {
                        //更新最小子串的起始索引
                        start = left;
                        //更新最小子串的长度
                        len = right - left;
                    }

                    //d是即将移出窗口的元素
                    char d = s2.charAt(left);
                    //窗口收缩
                    left++;
                    //进行一系列的数据更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d,window.get(d) - 1);
                    }
                }
            }

            return len == s1.length() ? true : false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here
        
    }
}