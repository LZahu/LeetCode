//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6433 👎 0


public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 两种特殊情况
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            // 对应节点相加
            ListNode indexL1 = l1;
            ListNode indexL2 = l2;
            ListNode pre = new ListNode();
            ListNode indexResult = pre;
            ListNode node = null;
            int carry = 0;
            while (indexL1 != null && indexL2 != null) {
                node = new ListNode((indexL1.val + indexL2.val + carry) % 10);
                carry = (indexL1.val + indexL2.val + carry) / 10;
                indexResult.next = node;
                indexResult = indexResult.next;
                indexL1 = indexL1.next;
                indexL2 = indexL2.next;
            }

            // 剩余节点
            ListNode temp = null;
            if (indexL1 == null && indexL2 != null) {
                temp = indexL2;
            }
            if (indexL2 == null && indexL1 != null) {
                temp = indexL1;
            }

            while (temp != null) {
                node = new ListNode((temp.val + carry) % 10);
                carry = (temp.val + carry) / 10;
                indexResult.next = node;
                indexResult = indexResult.next;
                temp = temp.next;
            }

            // 保留最后的进位
            if (carry != 0){
                node.next = new ListNode(carry);
            }

            return pre.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}