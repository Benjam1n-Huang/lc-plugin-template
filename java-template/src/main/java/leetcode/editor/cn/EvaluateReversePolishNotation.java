package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class EvaluateReversePolishNotation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            //遇到数字就压入栈
            //遇到运算符就弹出栈顶的两个元素，然后将运算结果重新压入栈
            Stack<Integer> stk = new Stack<>();
            for(String token : tokens) {
                if ("+".equals(token)) {
                    // 对于 + 和 *，顺序不重要
                    stk.push(stk.pop() + stk.pop());
                } else if ("-".equals(token)) {
                    Integer num2 = stk.pop(); // 先弹出的是第二个操作数
                    Integer num1 = stk.pop(); // 后弹出的是第一个操作数
                    stk.push(num1 - num2);    // 执行 num1 - num2
                } else if ("*".equals(token)) {
                    // 对于 + 和 *，顺序不重要
                    stk.push(stk.pop() * stk.pop());
                } else if ("/".equals(token)) {
                    Integer num2 = stk.pop(); // 先弹出的是第二个操作数
                    Integer num1 = stk.pop(); // 后弹出的是第一个操作数
                    stk.push(num1 / num2);    // 执行 num1 / num2
                } else {
                    stk.push(Integer.parseInt(token));
                }
            }

            return stk.pop();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        // put your test code here
        
    }
}