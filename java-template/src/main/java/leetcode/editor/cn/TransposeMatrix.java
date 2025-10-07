package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TransposeMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] transpose(int[][] matrix) {
            //首先获取到原矩阵的行和列
            int m = matrix.length, n = matrix[0].length;
            //转置矩阵的长宽颠倒
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][i] = matrix[i][j];
                }
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TransposeMatrix().new Solution();
        // put your test code here
        
    }
}