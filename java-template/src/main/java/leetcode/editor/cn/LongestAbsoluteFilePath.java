package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestAbsoluteFilePath {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String input) {
            //这个栈存储之前的父路径。实际上这里只用存父路径的长度就够了
            Deque<String> stack = new LinkedList<>();
            int maxLen = 0;
            for(String part : input.split("\n")) {
                //计算当前文件或目录的“深度”或“层级”
                int level = part.lastIndexOf("\t") + 1;
                //让栈中只保留当前目录的父路径
                while(level < stack.size()) {
                    stack.removeLast();
                }
                stack.addLast(part.substring(level));
                //如果是文件，就计算路径长度
                if(part.contains(".")) {
                    int sum = stack.stream().mapToInt(String::length).sum();
                    // 加上父路径的分隔符
                    sum += stack.size() - 1;
                    maxLen = Math.max(maxLen, sum);
                }
            }
            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestAbsoluteFilePath().new Solution();
        // put your test code here
        
    }
}