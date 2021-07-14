//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1245 👎 0


// 2021-02-23 22:15:15
public class SymmetricTree{
    public static void main(String[] args){
        Solution solution = new SymmetricTree().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
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
    public boolean isSymmetric(TreeNode root) {
        // 根节点空，直接返回false
        if (root == null)
            return false;
        else
            return isSymmetric(root.left, root.right);
    }

    // 重载方法
    public boolean isSymmetric(TreeNode left, TreeNode right){
        // 左右节点均为空，同样是对称，返回true
        if (left==null && right==null)
            return true;
        // 左右节点只有一个为空，不对称，返回false
        else if (left==null || right==null)
            return false;
        // 左右节点值不同，不对称，返回false
        else if (left.val != right.val)
            return false;

        TreeNode l_left = left.left;
        TreeNode l_right = left.right;
        TreeNode r_left = right.left;
        TreeNode r_right = right.right;

        // 分别比较对称位置上的节点
        return isSymmetric(l_left, r_right) && isSymmetric(l_right, r_left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}