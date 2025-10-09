package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SimplifyPath {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            //利用栈的LIFO的特性处理上级目录..，最后组装化简好的路径即可
            String[] parts = path.split("/");
            Stack<String> stk = new Stack<>();

            //借助栈计算最终的文件路径
            for (String part : parts) {
                if(part.isEmpty() || part.equals(".")) {
                    continue;
                }

                //两个点 ".." 表示上一级目录（父目录）
                if(part.equals("..")) {
                    if(!stk.isEmpty()) {
                        stk.pop();
                    }
                    continue;
                }

                stk.push(part);
            }

            //栈中存储的文件夹组成路径
            String res = "";
            while (!stk.isEmpty()) {
                res = "/" + stk.pop() + res;
            }
            return res.isEmpty() ? "/" : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        // put your test code here
        
    }
}