//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 595 👎 0


// 2021-02-19 16:31:33
public class Sqrtx{
    public static void main(String[] args){
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(10));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x==0 | x==1){
            return x;
        }

        int left = 1;
        int right = x / 2;

        // 可以在逻辑上虚构一个从1到 x/2的数组
        // left指向第一个，right指向最后一个
        // mid默认为 1，也就是二分查找没找到的情况
        int mid = 1;
        while(left <= right){
            mid = (left + right) / 2;
            // x = 2、3的时候是不成立的，相当于查找不到的情况
            // 此时，mid=1（默认值）
            if (mid == x/ mid)
                return mid;
            else {
                if (mid < x/mid)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}