//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 305 👎 0


import java.util.ArrayList;
import java.util.List;

// 2021-04-25 23:07:47
public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args){
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();

        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABE";
        System.out.println(solution.exist(board, word));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty() || word.length() > board.length * board[0].length){
            return false;
        }

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                boolean flag = dfs(i, j, board, used, word.toCharArray(), new ArrayList<>());
                if (flag){
                    return true;
                }
            }
        }

        return false;

    }

    public boolean dfs(int row, int col, char[][] board, boolean[][] used, char[] word, List<Character> list){
        if (list.size() == word.length){
            return true;
        }
        // 出界
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        // 对应字符不相等
        int len = list.size();
        if (used[row][col] || board[row][col] != word[len]){
            return false;
        }
        // 暂存
        list.add(board[row][col]);
        used[row][col] = true;
        // 向下遍历
        boolean flag = dfs(row, col + 1, board, used, word, list) ||
                dfs(row, col - 1, board, used, word, list) ||
                dfs(row + 1, col, board, used, word, list) ||
                dfs(row - 1, col, board, used, word, list);
        // 后续字符不符合，回溯
        if (!flag){
            list.remove(len);
            used[row][col] = false;
        }

        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}