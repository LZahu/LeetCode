//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 95 👎 0


import java.util.*;

// 2021-05-06 20:42:06
public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args){
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        solution.levelOrder(root);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        down(level, list, true);
        return list;
    }

    public void down(List<TreeNode> level, List<List<Integer>> list, boolean left){
        if (level.isEmpty()){
            return;
        }

        List<Integer> l = new ArrayList<>(level.size());
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : level){
            // 标记下存储的顺序
            if (left){
                l.add(node.val);
            } else {
                l.add(0, node.val);
            }

            if (node.left != null){
                nextLevel.add(node.left);
            }
            if (node.right != null){
                nextLevel.add(node.right);
            }
        }
        list.add(l);

        down(nextLevel, list, !left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
}