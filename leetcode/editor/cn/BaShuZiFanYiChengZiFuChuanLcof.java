//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 226 👎 0


// 2021-05-18 23:19:18
public class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args){
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(12258));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        if (num < 10){
            return 1;
        }

        String number = String.valueOf(num);
        int[] dp = new int[number.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        // 如果当前字符和前一个字符组成的数值小于26，说明可以作为一种翻译方法
        // 并且，数值第一个数不能为0
        // 则dp[i] = dp[i-1] + dp[i-2]
        // 否则，dp[i] = dp[i-1]
        int a;
        String s;
        for (int i = 2; i < dp.length; i++){
            s = number.substring(i - 2, i);
            a = Integer.parseInt(s);
            if (s.charAt(0) != '0' && a < 26){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}