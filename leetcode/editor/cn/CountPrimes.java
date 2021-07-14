//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 663 👎 0


import java.util.ArrayList;
import java.util.List;

// 2021-04-11 16:14:31
public class CountPrimes{
    public static void main(String[] args){
        Solution solution = new CountPrimes().new Solution();
        System.out.println(solution.countPrimes(100));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;

        boolean[] isPrime = new boolean[n];
        int count = 0;

        for (int i=2; i<n; i++){
            if (!isPrime[i]){
                count ++;
//                System.out.print(i + "   ");
                // 标记i的倍数
                mark(isPrime, i, n);
            }
        }

        return count;
    }

    // 标记一个数的所有倍数，这些被标记的数不是质数
    public void mark(boolean[] isPrime, int num, int n){
        if (Math.pow(num, 2) < n){
            for (int i=(int)Math.pow(num, 2); i<n; i+=num){
                isPrime[i] = true;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}