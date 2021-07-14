//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 103 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 2021-05-02 00:18:08
public class CongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args){
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
        
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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        putIn(queue, res);
        return res;
    }

    // 实际上就是层序遍历
    public void putIn(Queue<TreeNode> queue, List<List<Integer>> res){
        if (queue.isEmpty())
            return;

        // 记录当前队列中的节点个数，也就是当前层的节点个数
        int len = queue.size();
        List<Integer> list = new ArrayList<>(len);
        TreeNode node;
        for (int i = 0; i < len; i++){
            node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        res.add(list);
        putIn(queue, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
}