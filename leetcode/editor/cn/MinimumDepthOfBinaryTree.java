//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 456 👎 0


import java.lang.management.MemoryManagerMXBean;

// 2021-02-23 23:44:22
public class MinimumDepthOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

class Solution {
    public int minDepth(TreeNode root) {
        // 根节点空
        if (root == null)
            return 0;

        // 只有一个根节点，或为叶子节点
        if (root.left == null && root.right == null)
            return 1;

        // 关键在于寻找叶子节点
        // 左子树没有，则深度搜索右子树
        if (root.left == null)
            return minDepth(root.right) + 1;
        // 右子树没有，则深度搜索左子树
        else if (root.right == null)
            return minDepth(root.left) + 1;
        // 左右子树均存在，取深度较小值
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}