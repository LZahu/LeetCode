//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 208 👎 0


import java.util.ArrayList;
import java.util.List;

// 2021-05-10 15:00:25
public class BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args){
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        int[] arr = {3,30,34,5,9};
        System.out.println(solution.minNumber(arr));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 回溯超时
    class Solution {
        public String minNumber(int[] nums) {
            if (nums.length == 1) {
                return String.valueOf(nums[0]);
            }

            String[] str = new String[nums.length];
            for (int i = 0; i < nums.length; i++){
                str[i] = String.valueOf(nums[i]);
            }

            quickSort(str, 0, str.length - 1);
            StringBuilder res = new StringBuilder();
            for (String s : str) {
                res.append(s);
            }

            return res.toString();
        }

        // 快排，按特定的字典序
        // xy < yx，则x<y
        public void quickSort(String[] str, int left, int right){
            if (left >= right){
                return;
            }

            int i = left, j = right;
            String tmp = str[left];
            while (i < j){
                while (i < j && (str[j] + str[left]).compareTo((str[left] + str[j])) >= 0){
                    j --;
                }
                while (i < j && (str[i] + str[left]).compareTo((str[left] + str[i])) <= 0){
                    i ++;
                }
                tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }
            str[i] = str[left];
            str[left] = tmp;

            quickSort(str, left, i - 1);
            quickSort(str, i + 1, right);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}