//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3675 👎 0


import java.util.Arrays;

// 2021-02-06 18:56:27
public class MedianOfTwoSortedArrays{
    public static void main(String[] args){
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1,2,4,5,7,9};
        int[] nums2 = {2,4,6,9,10,12,14};

        double center = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(center);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;

            double center= 0.0;
            // 总长度是奇数
            if (len % 2 == 1){
                center = getKthElement(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (len+1)/2);
            }
            // 总长度是偶数
            else {
                int left = getKthElement(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2);
                int right = getKthElement(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1);
                center = (left + right) / 2.0;
            }

            return center;
        }

        private int getKthElement(int[] nums1, int s1Start, int s1End, int[] nums2, int s2Start, int s2End, int kth ){
            // 两个数组待比较部分的长度
            int s1Len = s1End - s1Start + 1;
            int s2Len = s2End - s2Start + 1;
            // 始终保持长度较短的是数组nums1
            if (s2Len < s1Len){
                return getKthElement(nums2, s2Start, s2End, nums1, s1Start, s1End, kth);
            }

            // 如果较短数组已经全部比较完，那么只需将nums2对应位置的值返回即可
            if (s1Len == 0){
                return nums2[s2Start+kth-1];
            }

            // 如果还剩最后一个，且两个数组都还未比较完，那么返回较小的数值即可
            if (kth == 1){
                return Math.min(nums1[s1Start], nums2[s2Start]);
            }

            // 先计算每个数组需要比较的部分的最后一个位置索引
            // 这里需要考虑数组长度的问题
            int s1Index = Math.min(s1End, s1Start + kth/2 - 1);
            int s2Index = Math.min(s2End, s2Start + kth/2 - 1);

            // 比较大小，并舍弃数值较小的数组的比较部分
            if (nums1[s1Index] <= nums2[s2Index]){
                return getKthElement(nums1, s1Index+1, s1End, nums2, s2Start, s2End, kth-(s1Index-s1Start+1));
            }
            else {
                return getKthElement(nums1, s1Start, s1End, nums2, s2Index+1, s2End, kth-(s2Index-s2Start+1));
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}