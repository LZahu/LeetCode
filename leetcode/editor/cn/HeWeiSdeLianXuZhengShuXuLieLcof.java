//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 257 👎 0


import java.util.ArrayList;
import java.util.List;

// 2021-05-04 23:21:40
public class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args){
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        long delta;
        long sqrt;
        for (int x = 1; x <= target / 2; x++){
            // 求和公式，解一元二次方程Δ
            delta = 1 - 4 * (x - (long)x * x - 2 * target);
            if (delta < 0){
                continue;
            }

            sqrt = (long) Math.sqrt(delta);
            if (sqrt * sqrt == delta && sqrt % 2 == 1){
                int y = (int) (sqrt - 1) / 2;
                if (x < y){
                    int[] a = new int[y - x + 1];
                    for (int i = x; i <= y; i++){
                        a[i - x] = i;
                    }
                    list.add(a);
                }
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}