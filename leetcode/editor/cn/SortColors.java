//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 834 👎 0


import java.util.Arrays;

// 2021-04-05 00:21:32
public class SortColors{
    public static void main(String[] args){
        Solution solution = new SortColors().new Solution();

        int[] arr = {2, 1, 0, 0, 1, 1, 2};
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        // 空数组，或者只有一个元素
        if (nums.length==0 || nums.length==1)
            return;

        // 找到当前数组的最大值和最小值
        int minNum = 3;
        int maxNum = -1;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        int left;
        int right = nums.length - 1;
        // 最多两轮循环
        // 第一轮，将2放在右边，将0和1放在左边
        // 第二轮，将1放在右边，将0放在左边
        // 如果数组只包含两种数，则一轮循环即可，小在左，大在右
        for (int flag=maxNum; flag>minNum; flag--){
            left = 0;
            while (left < right){
                while (left<right && nums[left]<flag){
                    left ++;
                }
                while (left<right && nums[right]==flag){
                    right --;
                }

                if (left<right){
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }
            }
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}