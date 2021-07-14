//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 92 👎 0


import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

// 2021-05-02 00:33:18
public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args){
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if (s.equals(""))
            return ' ';

        if (s.length() == 1)
            return s.charAt(0);

        // 保留输入的顺序
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chs = s.toCharArray();

        for (char c : chs){
            if (!map.containsKey(c)){
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }

        // 按输入的顺序遍历
        char c = ' ';
        Set<Character> keySet = map.keySet();
        for (Character key : keySet){
            if (map.get(key) == 1){
                c = key;
                break;
            }
        }

        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}