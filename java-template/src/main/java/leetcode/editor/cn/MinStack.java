package leetcode.editor.cn;

import java.lang.invoke.VarHandle;
import java.util.*;

import leetcode.editor.common.*;
//leetcode submit region begin(Prohibit modification and deletion)
public class MinStack {
    //记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    //阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public void push(int val) {
        stk.push(val);
        //维护minStk栈顶为全栈最小元素
        if (minStk.isEmpty() || val <= minStk.peek()) {
            //新插入的这个元素就是全栈最小的
            minStk.push(val);
        } else {
            //新插入的这个元素比较大
            minStk.push(minStk.peek());
        }
    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        //minStk栈顶为全栈最小元素
        return minStk.peek();
    }


    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    public static void main(String[] args) {
        // put your test code here

    }
}
//leetcode submit region end(Prohibit modification and deletion)