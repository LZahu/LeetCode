//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1110 👎 0


import java.util.ArrayList;
import java.util.List;

// 2021-04-19 15:55:44
public class NumberOfIslands{
    public static void main(String[] args){
        Solution solution = new NumberOfIslands().new Solution();
        char[][] chs = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(solution.numIslands(chs));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] isVisited = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1' && !isVisited[i][j]){
                    List<int[]> list = new ArrayList<>();
                    dfs(i, j, grid, isVisited, list);
                    if (list.size() > 0){
                        count ++;
                    }
                }
            }
        }

        return count;

    }

    // 深度优先遍历
    public void dfs(int m, int n, char[][] grid, boolean[][]isVisited, List<int[]> list){
        if (m < 0 || m >= grid.length || n >= grid[0].length || n < 0 || isVisited[m][n] || grid[m][n] == '0')
            return;

        list.add(new int[]{m, n});
        isVisited[m][n] = true;

        // 上下左右都遍历
        dfs(m, n + 1, grid, isVisited, list);
        dfs(m, n - 1, grid, isVisited, list);
        dfs(m + 1, n, grid, isVisited, list);
        dfs(m - 1, n, grid, isVisited, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}