//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 430 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 2021-04-24 22:31:43
public class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args){
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        // 构建队列，存储当前层的所有节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        traverseDown(queue, res);
        return res;
    }

    // 递归，遍历当前层每个节点，并放入res中，且将下层节点放入queue中
    public void traverseDown(Queue<TreeNode> queue, List<List<Integer>> res){
        // 如果queue为空，说明到底了，没有任何节点了
        if (queue.size() == 0){
            return;
        }

        int len = queue.size();
        TreeNode node;
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++){
            node = queue.poll();
            list.add(node.val);
            // 加入左右子节点，也就是下一层的节点
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        // 每次都在首端插入
        res.add(0, list);

        traverseDown(queue, res);
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