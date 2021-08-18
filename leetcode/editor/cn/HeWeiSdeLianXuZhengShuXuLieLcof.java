//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 305 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：和为s的连续正数序列
public class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] findContinuousSequence(int target) {
        int sum = 1;
        List<int[]> res = new ArrayList<>();
        for (int i = 1, j = i+1; i < j && j<target; ) {
            if(sum+j<target) {
                sum = sum+j;
                j++;
            } else if (sum+j>target) {
                sum-=i;
                i++;
            } else {
                int[] tmp = new int[j-i+1];
                for (int k = 0; k < tmp.length; k++) {
                    tmp[k] = k+i;
                }
                i++;
                j++;
                sum-=i;
                sum+=j;
                res.add(tmp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}