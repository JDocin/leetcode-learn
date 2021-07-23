//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 

package leetcode.editor.cn;
import javax.swing.*;
import java.util.*;
// Java：从上到下打印二叉树
public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        // TO TEST
    }
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                TreeNode tmp = q.poll();
                list.add(tmp.val);
                if (tmp.left != null) q.offer(tmp.left);
                if (tmp.right != null) q.offer(tmp.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}