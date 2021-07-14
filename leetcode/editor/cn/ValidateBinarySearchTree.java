//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1035 👎 0


import com.sun.source.tree.Tree;

// 2021-04-24 22:35:59
public class ValidateBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new ValidateBinarySearchTree().new Solution();
        
    }
    
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
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return false;
        }

        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    // 遍历每个节点，并给出应该所在的范围
    public boolean isValid(TreeNode node, long up, long down){
        if (node == null){
            return true;
        }
        else {
            // 节点值不在范围内
            if (node.val >= up || node.val <= down){
                return false;
            }
            // 节点值在范围内
            // 向下继续遍历
            else {
                return isValid(node.left, node.val, down) && isValid(node.right, up, node.val);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
}