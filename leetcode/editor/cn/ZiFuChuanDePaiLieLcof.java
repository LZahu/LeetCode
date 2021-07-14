//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 260 👎 0


import java.util.*;

// 2021-05-06 21:49:43
public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args){
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        solution.permutation("abc");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Character>> str = new ArrayList<>();
        private List<Character> list = new ArrayList<>();

        public String[] permutation(String s) {
            char[] chs = s.toCharArray();
            boolean[] used = new boolean[chs.length];
            Arrays.sort(chs);
            dfs(chs, used);

            Set<String> set = new HashSet<>();
            for (List<Character> l : str){
                StringBuilder sb = new StringBuilder();
                for (Character c : l){
                    sb.append(c);
                }
                set.add(sb.toString());
            }

            String[] res = new String[set.size()];
            int i = 0;
            for (String ss : set){
                res[i ++] = ss;
            }
            return res;
        }

        public void dfs(char[] chs, boolean[] used){
            if (list.size() == chs.length){
                str.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < chs.length; i++){
                if (!used[i]){
                    list.add(chs[i]);
                    used[i] = true;
                    dfs(chs, used);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}