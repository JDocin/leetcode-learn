//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 141 👎 0

package leetcode.editor.cn;
import java.sql.PreparedStatement;
import java.util.*;
// Java：合并两个排序的链表
class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        // TO TEST
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null) return null;
        ListNode head = new ListNode(-1);
        ListNode p=head;
        while (l1!=null&&l2!=null) {
            if(l1.val<=l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1!=null) p.next=l1;
        else if(l2 !=null) p.next=l2;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution2 {
    //递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.递归结束的条件（这个条件能够直接得到递归结果）。
        //①这里最能直接得到结果的是l1 == null && l2 == null，因此刚开始可能结束条件只写了这一点。②但是当后面写出函数等价关系式后，要回过来检查是否有遗漏的条件。本题中：若传入函数的l1/l2仅有一个节点，则后面会报空指针异常，因此也要仅有一个节点的情况加到递归结束的条件中。
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        //2.函数等价关系式（这个关系式可以化简原函数关系式）。
        //①原关系式是：合并两个分别含有m、n个节点的排序链表。②等价关系式是：合并两个分别含有m-1、n或m、n-1个节点的排序链表+特殊处理减掉的那个节点。
        if(l1.val <= l2.val){
            head = l1;
            l1.next = mergeTwoLists(l1.next,l2);
        }else{
            head = l2;
            l2.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
}

}
