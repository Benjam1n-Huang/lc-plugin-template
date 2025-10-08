package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestRepeatingCharacterReplacement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            //维护一个滑动窗口在字符串s上,保证窗口内的所有字符都被替换成一样的，那么窗口的最大长度就是题目的答案
            //窗口内的字符数量是right - left
            //把所有字符都替换成 x 所需的替换次数就是 right - left - windowMaxCount
            int left = 0 ,right = 0;
            //记录窗口内每个字符的出现次数
            int[] windowCharCount = new int[26];
            //记录窗口中字符的最多重复次数
            //记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
            int windowMaxCount = 0;
            //记录窗口的长度
            int res = 0;

            while(right < s.length()) {
                //即将加入窗口内的字符
                int c = s.charAt(right) - 'A';
                //扩大窗口
                right++;
                //进行数据更新
                windowCharCount[c]++;
                windowMaxCount = Math.max(windowMaxCount, windowCharCount[c]);

                //尝试进行窗口缩小
                //当 right - left - windowMaxCount <= k 时，在可控范围内，整个窗口内的字符都可以替换成相同的
                //反之 right - left - windowMaxCount > k 时说明 k 次替换机会不足以使窗口内的字符全部相同，此时必须缩小窗口
                while(right - left - windowMaxCount > k) {
                    int d = s.charAt(left) - 'A';
                    windowCharCount[d]--;
                    left++;
                }

                //经过收缩之后，肯定是一个合法的窗口
                res = Math.max(res, right - left);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        // put your test code here
        
    }
}