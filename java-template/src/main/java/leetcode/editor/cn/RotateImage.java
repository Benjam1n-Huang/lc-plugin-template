package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RotateImage {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            //先让矩阵沿对角线进行镜像反转
            //然后反转矩阵每一行
            int n = matrix.length;
            //先沿对角线反转二维矩阵
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    //swap(matrix[i][j],matrix[j][i])
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            //然后反转二维矩阵的每一行
            for(int[] row : matrix) {
                reverse(row);
            }

        }

        public void reverse(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // put your test code here
        
    }
}