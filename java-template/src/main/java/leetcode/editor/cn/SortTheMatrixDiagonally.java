package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SortTheMatrixDiagonally {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            //可以发现矩阵在同一个对角线上的元素，其横纵坐标之差是相同的
            //所以采用哈希表把每个对角线的元素存起来，想办法排序，最后放回二维矩阵上即可
            int m = mat.length, n = mat[0].length;
            // 存储所有对角线的元素列表
            HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 横纵坐标之差可以作为一条对角线的 ID
                    int diagonalID = i - j;
                    diagonals.putIfAbsent(diagonalID,new ArrayList<>());
                    diagonals.get(diagonalID).add(mat[i][j]);
                }
            }

            //从数组末尾删除元素的效率较高,所以我们把ArrayList倒序排序
            for (List<Integer> diagonal : diagonals.values()) {
                Collections.sort(diagonal,Collections.reverseOrder());
            }

            //把排序结果填回二维矩阵
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> diagonal = diagonals.get(i - j);
                    mat[i][j] = diagonal.remove(diagonal.size() - 1);
                }
            }

            return mat;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SortTheMatrixDiagonally().new Solution();
        // put your test code here
        
    }
}