//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 576 👎 0


import java.util.HashSet;
import java.util.Set;

// 2021-04-11 15:26:38
public class HappyNumber{
    public static void main(String[] args){
        Solution solution = new HappyNumber().new Solution();
        System.out.println(solution.isHappy(7));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        if (n == 0)
            return false;

        if (n == 1 || n == 10)
            return true;

        Set<Integer> set = new HashSet<>();
        int sum = n;
        while (sum != 1){
            n = sum;
            sum = 0;
            // 求和
            while (n != 0){
                sum += (int)Math.pow(n % 10, 2);
                n /= 10;
            }
            // 判断和是否重复
            if (set.contains(sum))
                return false;
            else
                set.add(sum);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}