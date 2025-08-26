package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthSmallestElementInASortedMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            //问题的本质是合并k个有序链表，然后找到第k个元素即可
            //1. 首先将矩阵的每一列转化为一个链表
            ListNode[] heads = new ListNode[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                //每行的第一个元素是头节点
                ListNode head = new ListNode(matrix[i][0]);
                ListNode p = head;
                //从每行的第二个元素开始遍历该行
                for (int j = 1; j <matrix[i].length; j++) {
                    ListNode node = new ListNode(matrix[i][j]);
                    //将节点链接到链表末尾
                    p.next = node;
                    //p节点前移
                    p = p.next;
                }
                //装载完成
                heads[i] = head;
            }

            //2. 合并k个有序链表
            //虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            //创建小顶堆
            PriorityQueue<ListNode> pq = new PriorityQueue<>(heads.length, (a, b) -> (a.val - b.val));
            //将各个链表的头节点加入到小顶堆中
            for (ListNode head : heads) {
                pq.add(head);
            }
            //循环终止条件是小顶堆为空
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }

                //p前进
                p = p.next;
            }

            //3. 链表合并完成，且是升序链表，返回第k个元素即可
            ListNode res = dummy;
            for (int i = 0; i < k; i++) {
                res = res.next;
            }

            return res.val;

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