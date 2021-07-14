//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-search-tree/ 
// Related Topics 树 
// 👍 125 👎 0


// 2021-05-04 00:37:29
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(solution.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(1)));
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
        // 始终保持p的val小于q的val
        if (p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        // p、q分别在节点两侧，则该节点就是公共祖先
        if (p.val < root.val && q.val > root.val){
            return root;
        }

        // 该节点和p相等，则p节点就是公共祖先
        if (p.val == root.val){
            return p;
        }

        // 该节点和q相等，则q节点就是公共祖先
        if (q.val == root.val){
            return q;
        }

        // p、q的val都小于root的val，向val的左子树遍历
        if (q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        // p、q的val都大于root的val，向val的右子树遍历
        if (p.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
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