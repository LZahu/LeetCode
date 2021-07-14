//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 123 👎 0


// 2021-05-16 23:09:19
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof{
    public static void main(String[] args){
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        System.out.println(solution.findNthDigit(10));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        if (n == 0)
            return 0;

        // 判断n所指的位置属于几位数的范围，比如1~9，或者10~99等
        int a = n;
        int digit = 1;
        long start = 1;
        long count = 9;
        while (a > count){
            a -= count;
            digit ++;
            start *= 10;
            count = 9 * start * digit;
        }

        // 判断n所指的数值是多少
        long num = start + (a - 1) / digit;

        // 将对应的数值转换为字符串，然后找出对应位置的字符
        String numStr = Long.toString(num);
        return numStr.charAt((a - 1) % digit) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}