//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 255 👎 0


import java.util.Arrays;

// 2021-05-06 22:16:53
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{1,5,7,9,8,6}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 左右子树可能为空，也可能只有1个节点（此时不须比较）
        if (postorder.length == 0 || postorder.length == 1){
            return true;
        }

        // 将数组分为3部分，第一部分是左子树，第二部分是右子树，最后一部分是最后一个数值（即为根节点）
        int end = postorder.length - 1;
        int index = end - 1;
        // 找到右子树
        while (index >= 0 && postorder[index] > postorder[end]){
            index --;
        }
        int mid = index;

        // 找到左子树
        while (index >= 0 && postorder[index] < postorder[end]){
            index --;
        }
        if (index >= 0){
            return false;
        }

        // 左子树、右子树必须也是二叉搜索树
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, mid + 1)) &&
                verifyPostorder(Arrays.copyOfRange(postorder, mid + 1, end));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}