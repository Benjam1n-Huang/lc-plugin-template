package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SpiralMatrixIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            //思路和螺旋遍历矩阵的思路相同
            //首先规定上下左右四个边界
            int upper_bound = 0, lower_bound = n - 1;
            int left_bound = 0, right_bound = n - 1;
            //temp作为待插入的元素,初始值设置为1
            int temp = 1;
            int[][] arr = new int[n][n];
            //当arr中的元素数量为n^2时,跳出循环
            while (temp <= n * n) {
                if (upper_bound <= lower_bound) {
                    //在顶部,从左往右遍历插入
                    for (int i = left_bound; i <= right_bound; i++) {
                        arr[upper_bound][i] = temp;
                        temp++;
                    }
                    //上边界下移
                    upper_bound++;
                }

                if (left_bound <= right_bound) {
                    //在右侧,从上往下进行遍历
                    for (int i = upper_bound; i <= lower_bound; i++) {
                        arr[i][right_bound] = temp;
                        temp++;
                    }
                    //右边界左移
                    right_bound--;
                }

                if (upper_bound <= lower_bound) {
                    //在底部,从右往左遍历插入
                    for (int i = right_bound; i >= left_bound; i--) {
                        arr[lower_bound][i] = temp;
                        temp++;
                    }
                    //下边界上移
                    lower_bound--;
                }

                if (left_bound <= right_bound) {
                    //在左侧,从下往上进行遍历
                    for (int i = lower_bound; i >= upper_bound; i--) {
                        arr[i][left_bound] = temp;
                        temp++;
                    }
                    //左边界右移
                    left_bound++;
                }
            }

            return arr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // put your test code here
        
    }
}