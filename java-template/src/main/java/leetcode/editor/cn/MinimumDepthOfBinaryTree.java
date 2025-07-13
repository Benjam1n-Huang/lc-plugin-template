package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumDepthOfBinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left,right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    class Solution {

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);  //根结点入队
            //root 本身就是一层，depth初始化为1
            int depth = 1;

            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0;i < sz;i++) {
                    TreeNode cur = q.poll();
                    //判断是否到达叶子结点
                    if (cur.left == null && cur.right == null) {
                        return depth;
                    }
                    //将当前遍历结点的子节点入队
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                //这里增加步数
                depth++;
            }
            return depth;

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        // put your test code here
        
    }
}