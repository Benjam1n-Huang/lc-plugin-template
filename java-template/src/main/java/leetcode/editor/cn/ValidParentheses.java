package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            //首先将字符串转变为字符数组
            char[] charArray = s.toCharArray();
            //遍历这个字符数组，将右括号压入栈
           for (Character c : charArray) {
               //当遇到右括号时,从栈中弹出一个元素进行比对
               if (c.equals(')') || c.equals(']') || c.equals('}')) {
                   Character rightBracket = c;
                   //如果栈是空的,也返回false
                   if (stack.isEmpty()) {
                       return false;
                   }
                   Character leftBracket = stack.pop();
                   switch (c) {
                       case ')' -> {
                           if (!leftBracket.equals('(')) return false;
                       }
                       case ']' -> {
                           if (!leftBracket.equals('[')) return false;
                       }
                       case '}' -> {
                           if (!leftBracket.equals('{')) return false;
                       }
                   }
               }
               if (c.equals('(') || c.equals('[') || c.equals('{')) {
                   stack.push(c);
               }
           }
           if (!stack.isEmpty()) {
               return false;
           }
            return true;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("([])"));
        // put your test code here
        
    }
}