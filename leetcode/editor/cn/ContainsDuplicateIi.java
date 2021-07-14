//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 254 👎 0


import java.util.*;

// 2021-04-11 17:54:21
public class ContainsDuplicateIi{
    public static void main(String[] args){
        Solution solution = new ContainsDuplicateIi().new Solution();
        int[] nums = {0,1,2,3,4,5,0};
        System.out.println(solution.containsNearbyDuplicate(nums, 5));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return false;


        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], i);
            }
            else {
                int index = hashMap.get(nums[i]);
                // 判断两个相等元素的下标之间的插值是否小于等于k
                if (Math.abs(i - index) <= k){
                    return true;
                }
                else {
                    hashMap.put(nums[i], i);
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}