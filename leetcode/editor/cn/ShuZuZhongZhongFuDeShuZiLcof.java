//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 
// 👍 480 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：数组中重复的数字
class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        // TO TEST
        System.out.println(solution.findRepeatNumber(new int[]{1,2,3,4,6,1,2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 新建数组
    public int findRepeatNumber1(int[] nums) {
        boolean[] isCount = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (isCount[t]) {
                return t;
            } else {
                isCount[t] = true;
            }
        }
        return -1;
    }
    // 原地交换
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int t = nums[nums[i]];
                if (t == nums[i]) return t;
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}