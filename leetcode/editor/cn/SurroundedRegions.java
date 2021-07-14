//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 519 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2021-04-19 19:13:43
public class SurroundedRegions{
    public static void main(String[] args){
        Solution solution = new SurroundedRegions().new Solution();

        char[][] chs = {{'X', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        solution.solve(chs);
        for (int i = 0; i < chs.length; i++){
            for (int j = 0; j < chs[0].length; j++)
                System.out.print(chs[i][j] + " ");
            System.out.println();
        }
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // 如果board数组只有两行或者只有两列，不需更改
        if (row <= 1 || col <= 1){
            return;
        }

        boolean[][] isVisited = new boolean[row][col];

        List<List<int[]>> res = new ArrayList<>();
        for (int i = 1; i < row - 1; i++){
            for (int j = 1; j < col - 1; j++){
                // 从O开始遍历，前提是这个O没有被访问过
                if (!isVisited[i][j] && board[i][j] == 'O'){
                    List<int[]> list = new ArrayList<>();
                    dfs(i, j, board, isVisited, list);
                    // 将符合条件的O的位置保存
                    if (list.size() != 0 && list.get(0)[0] != 0 && list.get(0)[1] != 0){
                        res.add(list);
                    }
                }
            }
        }

        // 更改
        if (res.size() != 0){
            for (List<int[]> list : res){
                for (int[] arr : list){
                    board[arr[0]][arr[1]] = 'X';
                }
            }
        }

    }

    public void dfs(int row, int col, char[][] board, boolean[][] isVisited, List<int[]> list){
        if (row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1){
            if (board[row][col] == 'O') {
                // 如果此块区域中和边界上的O相邻，那么在首部插入一个空数组，标记
                list.add(0, new int[2]);
                return;
            }
            return;
        }

        if (board[row][col] == 'X' || isVisited[row][col])
            return;

        if (!isVisited[row][col] && board[row][col] == 'O'){
            list.add(new int[] {row, col});
            isVisited[row][col] = true;
        }

        dfs(row, col + 1, board, isVisited, list);
        dfs(row, col - 1, board, isVisited, list);
        dfs(row + 1, col, board, isVisited, list);
        dfs(row - 1, col, board, isVisited, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}