//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 559 👎 0


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021-04-22 22:28:37
public class BinaryTreePreorderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        // 构建栈
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node = root;
        while (!stack.empty()){
            // 先弹出栈顶节点
            node = stack.pop();
            res.add(node.val);
            // 压入当前节点的右节点
            if (node.right != null){
                stack.add(node.right);
            }
            // 压入当前节点的左节点
            if (node.left != null){
                stack.add(node.left);
            }
        }
        return res;
    }

    // 递归写法
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        // 根节点空
//        if (root == null){
//            return res;
//        }
//
//        preorderTraversal(root, res);
//        return res;
//    }
//
//    public void preorderTraversal(TreeNode node, List<Integer> list){
//        if (node == null){
//            return;
//        }
//        // 加入当前根节点
//        list.add(node.val);
//        // 左节点
//        preorderTraversal(node.left, list);
//        // 右节点
//        preorderTraversal(node.right, list);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
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