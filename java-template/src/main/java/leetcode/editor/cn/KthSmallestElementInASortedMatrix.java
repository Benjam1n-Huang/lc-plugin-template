package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthSmallestElementInASortedMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            //存储二元组(matrix[i][j],i,j)
            //i,j记录当前元素的索引位置，用于生成下一个节点
            //构造小根堆
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return a[0] - b[0];
            });

            //将矩阵的每一行的第一个元素放入到小根堆中
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[]{matrix[i][0],i,0});
            }

            int res = -1;
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                k--;
                int i = cur[1];
                int j = cur[2];
                if (j+1 < matrix.length) {
                    pq.offer(new int[]{matrix[i][j+1],i,j+1});
                }
            }

            return res;


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(solution.kthSmallest(matrix, 8));
    }
}