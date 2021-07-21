//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 145 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：调整数组顺序使奇数位于偶数前面
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length<=1) return nums;
        int i=0,j=1;
        while (j<nums.length){
            //i指向当前奇偶分界线，偶数第一个
            while (i<nums.length&&nums[i]%2 == 1) i++;
            j = i+1;
            //j向后找到第一个奇数，ranhoujiaohuan
            while (j<nums.length && nums[j]%2 == 0) j++;
            if(j<nums.length) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            j++;
        }
        return nums;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}