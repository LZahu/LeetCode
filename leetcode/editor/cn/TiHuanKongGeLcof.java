//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 103 👎 0


// 2021-04-25 22:23:51
public class TiHuanKongGeLcof{
    public static void main(String[] args){
        Solution solution = new TiHuanKongGeLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                str.append("%20");
            }
            else {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}