//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A
//" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "
//6" 和 "06" 不同。 
//
// 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行
//解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 675 👎 0


// 2021-04-18 16:53:23
public class DecodeWays{
    public static void main(String[] args){
        Solution solution = new DecodeWays().new Solution();

        System.out.println(solution.numDecodings("1010101"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;

        char[] chs = s.toCharArray();
        int n = chs.length - 1;
        int[] dp = new int[n + 1];

        // dp数组初始化
        dp[n] = (chs[n] == '0')? 0 : 1;

        // 递推公式：dp[i] = dp[i + 1] + dp[i + 2]
        // dp[i + 1]说明可以将当前字符作为单个字符分割
        // dp[i + 2]说明可以将当前字符和下一个字符作为整体分割，但是要求chs[i + 2] ！= ‘0’
        int number = 0;
        for (int i = n - 1; i >= 0; i--){
            // 当前字符是0，怎么分割都不行，直接置0
            if (chs[i] == '0'){
                dp[i] = 0;
                continue;
            }
            // 当前字符和下一个字符组合字符串对应的数值
            number = (chs[i] - '0') * 10 + (chs[i + 1] - '0');
            // 如果数值大于26
            // 或者当前字符后面第2个字符为0
            // 则不能合并，只能单独拆分
            if ((i + 2 <= n && chs[i + 2] == '0') || number > 26){
                dp[i] = dp[i + 1];
            }
            // 组合字符串对应的数值在0-26之间
            else {
                // 如果当前数值为倒数第2个字符
                // 最后+1是说明当前数值符合要求，再加上dp[i + 1]即可
                if (i + 2 > n){
                    dp[i] = dp[i + 1] + 1;
                }
                else {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            }
        }

        return dp[0];

    }

    // 回溯超时
//    public void dfs(int begin, char[] chs, int[] res){
//        // 越界
//        if (begin >= chs.length){
//            res[0] ++;
//            return;
//        }
//        // 当前字符为0的情况不可取，0只能和前面一个非零字符搭配
//        if (chs[begin] == '0')
//            return;
//
//        for (int len = 1; len <= Math.min(2, chs.length - begin); len++){
//            int number = 0;
//            // 划分长度为1
//            if (len == 1){
//                number = chs[begin] - '0';
//            }
//            // 划分长度为2
//            else if (begin + len <= chs.length){
//                number = (chs[begin] - '0') * 10 + chs[begin + 1] - '0';
//            }
//            // 如果可以解码，就加入
//            if (number > 0 && number <= 26){
//                dfs(begin + len, chs, res);
//            }
//        }
//
//        List<Integer> list = new ArrayList<>();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}