//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1362 👎 0


import java.util.Stack;

public class LongestValidParentheses{
    public static void main(String[] args){
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if (s.equals("") || s.length() <= 1){
            return 0;
        }

        // 利用栈，标记可以匹配的括号位置
        char[] chars = s.toCharArray();
        int[] symb = new int[chars.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '('){
                stack.push(i);
            } else {
                if (!stack.isEmpty()){
                    int left = stack.pop();
                    symb[left] = 1;
                    symb[i] = 1;
                }
            }
        }

        // 求连续标记的最大长度
        int length = 0;
        int maxL = 0;
        for (int i = 0; i < symb.length; i++){
            length = 0;
            while (i < symb.length && symb[i] == 1){
                length ++;
                i ++;
            }
            maxL = Math.max(maxL, length);
        }

        return maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}