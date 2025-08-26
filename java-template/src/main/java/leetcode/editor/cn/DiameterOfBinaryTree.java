package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DiameterOfBinaryTree {

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
        //记录最大直径长度
        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            //解决这题的关键在于，每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
            maxDepth(root);
            return maxDiameter;
        }

        int maxDepth(TreeNode root) {
            if (root == null) return 0;

            //求左子树的最大深度
            int leftMax = maxDepth(root.left);
            //求右子树的最大深度
            int rightMax = maxDepth(root.right);
            //更新最大深度
            int myDiameter = leftMax + rightMax;
            maxDiameter = Math.max(maxDiameter,myDiameter);

            //返回本节点为根节点时的树的最大深度
            return 1 + Math.max(leftMax,rightMax);
        }




    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        // put your test code here
        
    }
}