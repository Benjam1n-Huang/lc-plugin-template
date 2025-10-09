package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ImplementQueueUsingStacks {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        private Stack<Integer> s1,s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        //添加元素到队尾
        public void push(int x) {
            s1.push(x);
        }
        
        public int pop() {
            //先调用peek保证s2非空
            peek();
            return s2.pop();
        }
        
        public int peek() {
            if(s2.isEmpty()) {
                //把s1中的元素push到s2中
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }
        
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {

        // put your test code here
        
    }
}