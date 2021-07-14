//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5290 👎 0


import java.util.HashSet;
import java.util.Set;

// 2021-04-11 18:31:10
public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String str = "dvdf";
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        for (int i=0; i<s.length(); i++){
            int j = i;
            for ( ; j<s.length(); j++){
                if (j == i){
                    set.add(s.charAt(j));
                }
                else {
                    // 判断是否有重复字符出现
                    // 若有，退出当前循环
                    if (set.contains(s.charAt(j))){
                        break;
                    }
                    else {
                        set.add(s.charAt(j));
                    }
                }
            }
            // 保留maxLength和当前不重复子串长度的较大者
            // 继续下一轮循环，或者退出
            maxLength = Math.max(maxLength, set.size());
            set.clear();
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}