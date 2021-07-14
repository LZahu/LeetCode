//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1104 👎 0


import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        solution.buildTree(preorder, inorder);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

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

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0){
                return null;
            }

            if (preorder.length == 1){
                return new TreeNode(preorder[0]);
            }

            int rootVal = preorder[0];
            int rootIndex = 0;
            // 找到中序遍历中，根节点的位置
            while (rootIndex < inorder.length && inorder[rootIndex] != rootVal){
                rootIndex ++;
            }
            // 左子树的中序遍历
            int[] leftInorder = (rootIndex == 0)? new int[0] : Arrays.copyOfRange(inorder, 0, rootIndex);
            // 右子树的中序遍历
            int[] rightInorder = (rootIndex == inorder.length)? new int[0] : Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

            // 左子树的前序遍历
            int[] leftPreorder = (rootIndex == 0)? new int[0] : Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
            // 右子树的前序遍历
            int[] rightPreorder = (rootIndex == inorder.length)? new int[0] : Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

            TreeNode root = new TreeNode(rootVal);
            // 分治
            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}