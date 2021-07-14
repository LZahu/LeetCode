//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 851 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 2021-04-24 22:19:20
public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
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
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        res.add(list);

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