//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 316 👎 0


import java.util.Arrays;

// 2021-04-25 22:24:15
public class ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args){
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }


        // 标记位的行、列
        int index_row = 0;
        int index_col = matrix[0].length - 1;

        while (index_row < matrix.length && index_col >=0){
            if (matrix[index_row][index_col] == target){
                return true;
            }
            // 如果比target大，那就左移
            if (target < matrix[index_row][index_col]){
                index_col --;
            }
            // 如果比target小，那就下移
            else {
                index_row ++;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}