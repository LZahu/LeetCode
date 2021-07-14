//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1412 👎 0


// 2021-04-19 16:32:04
public class HouseRobber{
    public static void main(String[] args){
        Solution solution = new HouseRobber().new Solution();

        int[] nums = {2,7,9,3,1};
        System.out.println(solution.rob(nums));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        // 长度为0、1或2的三种特殊情况
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int n = nums.length - 1;
        int[] dp = new int[n + 1];

        // dp数组初始化
        dp[n] = nums[n];
        dp[n - 1] = nums[n - 1];

        // dp数组从后往前遍历
        // 递推公式：dp[i] = nums[i] + max(dp[i + 2], dp[i + 3])
        int maxValue = Math.max(dp[n], dp[n - 1]);
        for (int i = n - 2; i >= 0; i--){
            if (i + 3 > n){
                dp[i] = nums[i] + dp[i + 2];
            }
            else {
                dp[i] = nums[i] + Math.max(dp[i + 2], dp[i + 3]);
            }
            maxValue = Math.max(maxValue, dp[i]);
        }

        return maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}