//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1800 👎 0


import java.util.Arrays;

// 2021-04-11 15:50:37
public class SingleNumber{
    public static void main(String[] args){
        Solution solution = new SingleNumber().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        // 排序，相同的元素必相邻
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            // 某元素与其前后元素都不想等
            if (i == 0 && nums[i] != nums[i+1])
                return nums[i];
            if (i > 0 && nums[i] != nums[i+1] && nums[i+1] != nums[i+2])
                return nums[i+1];
        }

        // 只剩最后一个元素
        return nums[nums.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}