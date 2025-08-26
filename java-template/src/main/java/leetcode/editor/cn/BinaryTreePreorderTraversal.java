
package leetcode.editor.cn;

import java.sql.Array;
import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreePreorderTraversal {

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

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            //前序遍历的结果,root.val在第一个
            res.add(root.val);
            //递归遍历当前节点左子树的先序遍历结果
            res.addAll(preorderTraversal(root.left));
            //递归遍历当前节点右子树的先序遍历结果
            res.addAll(preorderTraversal(root.right));
            return res;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {

        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        // put your test code here
        TreeNode root = TreeNode.createRoot(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});

        List<Integer> result = solution.preorderTraversal(root);
        System.out.println(result);
    }
}