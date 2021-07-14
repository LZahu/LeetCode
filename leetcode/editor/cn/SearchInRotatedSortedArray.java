//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1265 👎 0


// 2021-04-01 20:28:33
public class SearchInRotatedSortedArray{
    public static void main(String[] args){
        Solution solution = new SearchInRotatedSortedArray().new Solution();

        int[] arr = new int[]{3, 1};
        int target = 1;
        int index = solution.search(arr, target);
        System.out.println(index);
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 旋转位置
        int rotationPosition = -1;

        // 寻找旋转位置
        for (int i=0; i<nums.length-1; i++){
            // 寻找期间，若找到匹配值，返回索引
            if (nums[i] == target)
                return i;
            // 记录旋转位置
            if (nums[i] > nums[i+1]){
                rotationPosition = i;
                break;
            }
        }

        // 之前遍历的不用再查找，从rotationPosition+1位置开始查找
        // 二分法
        int right = nums.length - 1;
        int left = (rotationPosition == -1)? 0 : rotationPosition + 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }

        // 未找到，返回-1
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}