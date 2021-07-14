//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 352 👎 0


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 2021-04-11 15:01:01
public class IntersectionOfTwoArrays{
    public static void main(String[] args){
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        // 将数组nums1的元素插入到set中（包含去重）
        for (int j : nums1) {
            set.add(j);
        }

        // 判断数组nums2的元素在nums1中是否出现
        // 若出现，插入到res中，且去重
        for (int j : nums2){
            if (set.contains(j)){
                res.add(j);
            }
        }

        // 将res转换为int[]
        int[] join = new int[res.size()];
        Iterator<Integer> iterator = res.iterator();
        int index = 0;
        while (iterator.hasNext()){
            join[index++] = iterator.next();
        }

        return join;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}