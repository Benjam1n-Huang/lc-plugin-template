package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindKPairsWithSmallestSums {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            //存储三元组（num1[i],num2[i],i）
            //i 记录nums2元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                //按照孰对的元素和升序排序
                return (a[0] + a[1]) - (b[0] + b[1]);
            });

            //不断地将可能的排列组合放进优先级队列中
            for (int i = 0; i < nums1.length; i++) {
                pq.offer(new int[]{nums1[i],nums2[0],0});
            }

            List<List<Integer>> res = new ArrayList<>();
            //执行合并多个有序链表的逻辑
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                k--;
                //链表中的下一个节点加入优先级队列
                int next_index = cur[2] + 1;
                if (next_index < nums2.length) {
                    pq.add(new int[]{cur[0],nums2[next_index],next_index});
                }

                List<Integer> pair = new ArrayList<>();
                pair.add(cur[0]);
                pair.add(cur[1]);
                res.add(pair);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        // put your test code here
        
    }
}