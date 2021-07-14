//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 125 👎 0


import java.util.Arrays;

// 2021-05-04 00:09:31
public class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args){
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int index = 0;
        // 寻找0的位置
        while (nums[index] == 0){
            index ++;
        }

        // 0的个数
        int count = index;

        int missing = 0;
        for (int i = index + 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]){
                return false;
            }
            missing += (nums[i] - nums[i - 1] - 1);
        }

        return count >= missing;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}