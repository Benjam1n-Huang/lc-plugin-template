package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            //将字符串变为字符数组
            char[] brackets = s.toCharArray();
            //利用栈的特性，遇到左括号就直接入栈，碰到右括号就弹出栈顶元素与右括号进行匹配
            Stack<Character> stk = new Stack<>();
            for(char bracket : brackets) {
                switch(bracket) {
                    //碰到左括号直接入栈
                    case '(','[','{' -> stk.push(bracket);
                    case ')' -> {
                        if(stk.isEmpty()){
                            return false;
                        } else if (!stk.peek().equals('(')) {
                            return false;
                        } else {
                            stk.pop();
                        }
                    }
                    case ']' -> {
                        if(stk.isEmpty()){
                            return false;
                        } else if (!stk.peek().equals('[')) {
                            return false;
                        } else {
                          stk.pop();
                        }
                    }
                    case '}' -> {
                        if(stk.isEmpty()){
                            return false;
                        } else if (!stk.peek().equals('{')) {
                            return false;
                        } else {
                            stk.pop();
                        }
                    }

                }
            }

            //如果栈空，说明括号都匹配完了，返回true，否则返回false;
            return stk.isEmpty() ? true : false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("([])"));
        // put your test code here
        
    }
}