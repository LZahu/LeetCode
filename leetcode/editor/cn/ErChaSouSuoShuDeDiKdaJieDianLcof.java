//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 153 👎 0


import java.util.ArrayList;
import java.util.List;

// 2021-05-04 22:58:18
public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        
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

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        rightDown(root, list, k);
        return list.get(k - 1);
    }

    public void rightDown(TreeNode node, List<Integer> list, int k){
        if (node == null || list.size() == k){
            return;
        }

        rightDown(node.right, list, k);
        list.add(node.val);
        rightDown(node.left, list, k);
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