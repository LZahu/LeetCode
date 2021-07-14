//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 856 👎 0
import java.util.*;

// 2021-02-19 20:45:13
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args){
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{5, 7, 7, 8, 8, 9, 10};
        int target = 8;
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 先排除一些可以直接得到结果的情况
        if (nums==null || nums.length<=0 || target<nums[0] || target>nums[nums.length-1])
            return new int[]{-1, -1};

        // 二分查找的左右指针
        int left = 0;
        int right = nums.length - 1;
        // 找到的某个位置，默认为-1
        int loc = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (target == nums[mid]){
                // 找到了，就保存这个位置
                loc = mid;
                break;
            }
            else {
                if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        int[] range = new int[2];
        // 分别查看已保存位置的左右两端是否还有相同元素
        int loc_left = loc;
        int loc_right = loc;
        // 左边
        for (int i=loc-1; i>=0; i--){
            if (nums[i] == target)
                loc_left = i;
            else
                break;
        }
        // 右边
        for (int i=loc+1; i< nums.length; i++){
            if (nums[i] == target)
                loc_right = i;
            else
                break;
        }

        // 保存左右位置
        // 没有找到的话就是-1，-1
        range[0] = loc_left;
        range[1] = loc_right;
        return range;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}