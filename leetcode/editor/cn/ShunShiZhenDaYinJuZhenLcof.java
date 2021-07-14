//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 239 👎 0


// 2021-05-02 00:01:34
public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args){
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];

        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        int index= 0;
        int[] out = new int[matrix.length * matrix[0].length];

        // 循环打印边界上的数
        while (left < right && up < down){
            for (int i = left; i < right; i++){
                out[index ++] = matrix[up][i];
            }
            for (int i = up; i < down; i++){
                out[index ++] = matrix[i][right];
            }
            for (int i = right; i > left; i--){
                out[index ++] = matrix[down][i];
            }
            for (int i = down; i > up; i--){
                out[index ++] = matrix[i][left];
            }

            left ++; right --;
            up ++; down --;
        }

        // 处理中间的数
        if (left == right && up != down){
            for (int i = up; i <= down; i++){
                out[index ++] = matrix[i][right];
            }
        }
        else if (left != right && up == down){
            for (int i = left; i <= right; i++){
                out[index ++] = matrix[up][i];
            }
        }
        else if (left == right && up == down){
            out[index] = matrix[up][left];
        }

        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}