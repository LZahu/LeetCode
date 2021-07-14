//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 139 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021-04-25 22:37:25
public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args){
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.add(node.val);
            node = node.next;
        }

        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.empty()){
            arr[i ++] = stack.pop();
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
}