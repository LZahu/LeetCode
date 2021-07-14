//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 206 👎 0


import java.util.HashMap;
import java.util.Map;

// 2021-05-19 00:14:07
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args){
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }

        char[] chs = s.toCharArray();
        // 左右指针，一次遍历
        int left = 0;
        int right = left;
        int subLength = 1;
        // hashmap保留当前无重复的子字符串
        Map<Character, Integer> map = new HashMap<>();

        int index = 0;
        while (left <= right && right < chs.length){
            // 找到重复的字符，否则直接遍历到最后
            while (right < chs.length){
                if (map.isEmpty() || !map.containsKey(chs[right])){
                    map.put(chs[right], right);
                    right ++;
                } else {
                    break;
                }
            }

            // 如果找到了重复的字符
            if (right < chs.length){
                index = map.get(chs[right]);
                subLength = Math.max(subLength, right - left);
                // left移动到子串中重复字符的后一位
                while (left <= index){
                    map.remove(chs[left], left);
                    left ++;
                }
            } else {
                subLength = Math.max(subLength, right - left);
            }
        }

        return subLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}