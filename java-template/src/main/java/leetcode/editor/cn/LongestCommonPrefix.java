package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestCommonPrefix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int m = strs.length;
            //以第一行的列数为基准
            int n = strs[0].length();
            for (int col = 0; col < n; col++) {
                for (int row = 1; row < m; row++) {
                    String thisStr = strs[row], preStr = strs[row - 1];
                    //判断每个字符串的col索引是否相同
                    if (col >= thisStr.length() || col >= preStr.length() ||
                        thisStr.charAt(col) != preStr.charAt(col)) {
                        //发现不匹配的字符,只有strs[row][0..col-1]是公共前缀
                        return strs[row].substring(0,col);
                    }
                }
            }
            return strs[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // put your test code here
        
    }
}