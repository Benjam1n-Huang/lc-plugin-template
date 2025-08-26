package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaximumDepthOfBinaryTree {

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
    class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            //分解问题，先求左子树的最大深度
            int leftDepth = maxDepth(root.left);
            //然后求右子树的最大深度
            int rightDepth = maxDepth(root.right);
            //获得其子树的最大深度
            int res = Math.max(leftDepth,rightDepth);

            //后序位置
            return 1 + res;

        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // put your test code here
        
    }
}