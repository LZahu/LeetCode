//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 819 👎 0


// 2021-02-19 17:46:53
public class SearchInsertPosition{
    public static void main(String[] args){
        Solution solution = new SearchInsertPosition().new Solution();

        int[] nums = new int[]{1, 3};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 简单判断
        if (target < nums[left])
            return 0;
        if (target > nums[right])
            return right + 1;

        // 极端情况下（插入的数比所有数都小），在首位插入
        // 将这个作为默认值，后面可以变动
        int loc = 0;
        // 在查找的同时，利用 loc 标定可能插入的位置
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if (nums[mid] < target){
                    left = mid + 1;
                    // 只要插入的数比某个数大，那么 left 指针都会后移的
                    // loc 指针可以随之后移
                    loc = left;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return loc;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}