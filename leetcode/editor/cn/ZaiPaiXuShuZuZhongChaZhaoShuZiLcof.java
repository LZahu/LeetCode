//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 123 👎 0


// 2021-05-02 23:36:22
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args){
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return 0;

        // 查找所在位置，若没有，返回0
        int index = isExist(nums, target);
        if (index == -1){
            return 0;
        }

        int left = index, right = index;
        while (left >= 0 && nums[left] == target){
            left --;
        }
        while (right < nums.length && nums[right] == target){
            right ++;
        }

        return right - left - 1;
    }

    // 二分法查找target
    public int isExist(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}