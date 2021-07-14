//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 571 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021-04-23 00:22:52
public class BinaryTreePostorderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        
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
    // 循环写法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // 记录上一个输出的节点，以判断当前节点的右节点是否被访问过
        TreeNode last = null;

        while (node != null || !stack.empty()){
            while (node != null){
                stack.add(node);
                node = node.left;
            }

            node = stack.peek();
            // 如果当前节点的右节点被访问过，或者没有右节点
            if (node.right == null || node.right == last){
                // 保存此根节点
                res.add(stack.pop().val);
                // 记录当前输出的节点
                last = node;
                node = null;
            }
            // 如果当前节点的右节点没有被访问过，那么继续访问右子树
            else {
                node = node.right;
            }
        }

        return res;
    }

    // 递归写法
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//
//        postorderTraversal(root, res);
//        return res;
//    }
//
//    public void postorderTraversal(TreeNode node, List<Integer> list){
//        if (node == null){
//            return;
//        }
//
//        postorderTraversal(node.left, list);
//        postorderTraversal(node.right, list);
//        list.add(node.val);
//    }
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