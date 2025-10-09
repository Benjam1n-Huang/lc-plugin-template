package leetcode.editor.cn;

import java.lang.invoke.VarHandle;
import java.util.*;
import leetcode.editor.common.*;

public class ImplementStackUsingQueues {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        //记录栈顶元素（队尾元素）
        int top_elem = 0;

        public MyStack() {

        }
        
        public void push(int x) {
           q.offer(x);
           top_elem = x;
        }
        
        public int pop() {
            //将队尾元素前的元素全部拿出来重新入队，这样最初的队尾元素就移动到了队头
            int size = q.size();
            while(size > 2) {
                q.offer(q.poll());
                size--;
            }

            //将队尾元素的前一个元素的值记录下来，因为它将成为新的队尾
            top_elem = q.peek();
            q.offer(q.poll());
            //此时原队尾元素移动到了队头，直接出队即可
            return q.poll();


        }
        
        public int top() {
            return top_elem;
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ImplementStackUsingQueues().new Solution();
        // put your test code here
        
    }
}