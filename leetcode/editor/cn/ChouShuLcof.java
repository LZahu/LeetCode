//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 160 👎 0


import java.util.*;

// 2021-05-19 00:25:44
public class ChouShuLcof{
    public static void main(String[] args){
        Solution solution = new ChouShuLcof().new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;

        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);

        int count = 1;
        long top = 1;
        while (count <= n){
            top = set.pollFirst();
            set.add(2 * top);
            set.add(3 * top);
            set.add(5 * top);

            count ++;
        }

        return (int)top;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}