//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 508 👎 0

package leetcode.editor.cn;
import javafx.scene.chart.AreaChartBuilder;

import java.util.*;
// Java：重建二叉树
class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
    HashMap<Integer, Integer> inmap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;
        if(preorder.length==1||inorder.length==1) return new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        TreeNode res = rebuild(preorder, 0, 0,preorder.length-1);
        return res;
    }

    public TreeNode rebuild(int[] pre, int pos, int l, int r){
        // (pre先序遍历数组，pos-当前在pre数组里的位置(当前根结点)， l-当前在in中序数组中的左范围， r-in的右范围)
        if (l > r) {
            return null;
        }
        TreeNode p = new TreeNode(pre[pos]);
        if(l != r) {
            int k = inmap.get(pre[pos]);
            p.left = rebuild(pre, pos + 1, l, k - 1);
            p.right = rebuild(pre, pos + k - l + 1, k + 1, r);
        }
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}