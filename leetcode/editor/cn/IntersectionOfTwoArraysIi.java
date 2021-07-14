//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 474 👎 0


import java.util.*;

// 2021-04-11 15:08:20
public class IntersectionOfTwoArraysIi{
    public static void main(String[] args){
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> s1 = new HashMap<>();
        Map<Integer, Integer> s2 = new HashMap<>();

        // 将两个数组nums1、nums2都放入HashMap中
        // key为数组元素的值
        // value为数组元素出现的次数
        for (int num : nums1){
            if (!s1.containsKey(num)){
                s1.put(num, 1);
            }
            else {
                s1.put(num, s1.get(num)+1);
            }
        }

        for (int num : nums2){
            if (!s2.containsKey(num)){
                s2.put(num, 1);
            }
            else {
                s2.put(num, s2.get(num)+1);
            }
        }

        // 遍历最短的HashMap
        if (s1.size() > s2.size()){
            Map<Integer, Integer> temp = s1;
            s1 = s2;
            s2 = temp;
        }

        // res添加共同存在的key
        // 添加次数为最小的value值
        List<Integer> res = new ArrayList<>();
        for (Integer key : s1.keySet()){
            if (s2.containsKey(key)){
                int count = Math.min(s1.get(key), s2.get(key));
                for (int i=0; i<count; i++){
                    res.add(key);
                }
            }
        }

        int[] join = new int[res.size()];
        for (int i=0; i<join.length; i++){
            join[i] = res.get(i);
        }

        return join;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}