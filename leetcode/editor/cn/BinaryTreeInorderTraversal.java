//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 868 👎 0


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021-02-23 22:41:22
public class BinaryTreeInorderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 循环写法
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;

            while (node != null || !stack.empty()){
                // 先遍历左子树到底
                while (node != null){
                    stack.add(node);
                    node = node.left;
                }

                if (!stack.empty()){
                    // 左子树到底了，弹出，保存
                    node = stack.pop();
                    res.add(node.val);
                    // 再以它的右节点为根节点，遍历其左子树
                    node = node.right;
                }
            }

            return res;
        }
    // 循环写法
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null){
//            return res;
//        }
//
//        inorderTraversal(root, res);
//        return res;
//    }
//
//    public void inorderTraversal(TreeNode node, List<Integer> list){
//        if (node == null){
//            return;
//        }
//
//        inorderTraversal(node.left, list);
//        list.add(node.val);
//        inorderTraversal(node.right, list);
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