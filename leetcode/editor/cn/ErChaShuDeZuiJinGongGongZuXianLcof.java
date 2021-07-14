//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-tree/ 
// Related Topics 树 
// 👍 247 👎 0


import com.sun.source.tree.Tree;

import java.util.*;

// 2021-05-04 20:58:59
public class ErChaShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args){
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        System.out.println(solution.lowestCommonAncestor(root, node1, node8));
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parents = new HashMap<>();
        dfs(root, parents);

        Set<Integer> visited = new HashSet<>();
        // 从p往上找，保存所有的父节点，包括自己
        while (p != null){
            visited.add(p.val);
            p = parents.get(p.val);
        }
        // 从q往上找，重合的节点即为公共祖先
        while (q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parents.get(q.val);
        }

        return null;
    }

    // 保存每一个节点和它的父节点的关系
    public void dfs(TreeNode node, Map<Integer, TreeNode> parents){
        if (node == null){
            return;
        }

        if (node.left != null){
            parents.put(node.left.val, node);
            dfs(node.left, parents);
        }
        if (node.right != null){
            parents.put(node.right.val, node);
            dfs(node.right, parents);
        }
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
}