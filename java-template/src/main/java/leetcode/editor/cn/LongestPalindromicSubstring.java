package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class LongestPalindromicSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            //找到回文串的一个难点在于如果回文串的长度为偶数的话,就有两个中心点,如果为奇数,则只有一个中心点
            //解决该问题的核心是从中心向两端扩散的双指针技巧。
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                //以s[i]为中心的最长回文串
                String s1 = palinDrome(s, i, i);
                //以s[i],s[i+1]为中心的最长回文串
                String s2 = palinDrome(s, i, i + 1);
                //res = longest(s1,s2);
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }

            return res;
        }

        public String palinDrome(String s, int l, int r) {
            //防止索引越界
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                //向两边展开
                l--;
                r++;
            }

            //此时[l+1,r-1]就是最长的回文串
            return s.substring(l + 1, r);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // put your test code here

    }
}






