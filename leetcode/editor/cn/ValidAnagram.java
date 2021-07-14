//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 366 👎 0


// 2021-04-11 14:38:25
public class ValidAnagram{
    public static void main(String[] args){
        Solution solution = new ValidAnagram().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        // 以数组作为哈希表
        int[] isExit = new int[26];

        // 将字符串s中的每个字母在isExit哈希表中对应的位置处的数值+1
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            isExit[ch - 'a'] ++;
        }

        // 将字符串t中的每个字母在isExit哈希表中对应的位置处的数值-1
        for (int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            isExit[ch - 'a'] --;
        }

        // 判断哈希表isExit是否每个数值都为0
        for (int num : isExit){
            if (num != 0){
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}