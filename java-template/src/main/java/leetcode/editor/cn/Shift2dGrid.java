package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class Shift2dGrid {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            //问题的思路就是写一个 get 方法和 set 方法把二维数组抽象成一维数组
            //然后就转变为了将一个一维的数组平移 k 位
            //相当于分别翻转前 mn - k 个元素和后 k 个元素，最后反转所有元素

            //把二维数组grid抽象成一维数组
            int m = grid.length, n = grid[0].length;
            int mn = m * n; //总的元素数量
            //如果迁移次数等于mn的话,就意味着没有变化和原来相同
            k = k % mn;
            //先将最后k个元素进行翻转
            reverse(grid, mn - k, mn - 1);
            //然后翻转前mn-k个元素
            reverse(grid,0 , mn - k - 1);
            //最后整体翻转
            reverse(grid,0,mn - 1);
            //转化为List
            List<List<Integer>> res = new ArrayList<>();
            for (int[] row : grid) {
                List<Integer> rowList = new ArrayList<>();
                for (int e : row) {
                    rowList.add(e);
                }
                res.add(rowList);
            }

            return res;
        }

        //通过一维数组的索引访问二维数组的元素
        public int get(int[][] grid, int index) {
            //统计每行有几个元素
            int n = grid[0].length;
            //计算在二维数组中的索引
            int i= index / n, j = index % n;
            return grid[i][j];
        }

        //通过一维数组的索引,修改二维数组的元素
        public void set(int[][] grid, int index, int val) {
            //统计每行有几个元素
            int n = grid[0].length;
            //计算在二维数组中的索引
            int i= index / n, j = index % n;
            grid[i][j] = val;
        }

        //翻转一维数组的索引区间的元素
        public void reverse(int[][] grid, int i, int j) {
            while (i < j) {
                int temp = get(grid,i);
                set(grid, i , get(grid, j));
                set(grid, j, temp);
                i++;
                j--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
        // put your test code here
        
    }
}