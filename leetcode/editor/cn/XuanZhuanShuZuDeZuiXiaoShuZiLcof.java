//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 数组 二分查找 
// 👍 355 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：旋转数组的最小数字
class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        // TO TEST
        System.out.println(solution.minArray(new int[]{2,2,2,0,2,2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return -1;
        else if (numbers.length == 1) return numbers[0];
        else if (numbers.length == 2) return Math.min(numbers[0], numbers[1]);
        int l = 0;
        int r = numbers.length-1;
        if (numbers[l] < numbers[r]) return numbers[l];
        while (l<=r) {
            int mid = (l + r) >> 1;
            if (mid == l || mid == r) return Math.min(numbers[l], numbers[r]);
            if (numbers[l] == numbers[r] && numbers[l] == numbers[mid]) {
                int i =mid-1;
                boolean t = true;
                // 在左边范围内找凹点
                while (i>l && t) {
                    if(numbers[i]<numbers[l]) {
                        r = i;
                        t = false;
                    }
                    //碰到凸点，说明平线就是最小值
                    else if (numbers[i] > numbers[l]) return numbers[l];
                    else i--;
                }
                i = mid+1;
                // 左边没找到，在右边找凹点
                while (i<r && t) {
                    // 判断逻辑和左侧的相反
                    if(numbers[i]<numbers[r]) {
                        return numbers[i];
                    }
                    else if (numbers[i] > numbers[r]) {
                        l = i;
                        t = false;
                    }
                    else i++;
                }
                // 两边都没找到，直接返回平值
                if (t) return numbers[mid];
            }
            // 严格不等于的时候才能直接返回。
            else if (numbers[mid]<numbers[mid-1] && numbers[mid]<numbers[mid+1]) return numbers[mid];
            else if (numbers[mid]>=numbers[l] && numbers[mid]>=numbers[r]) l = mid;
            else if (numbers[mid]<=numbers[l] && numbers[mid]<=numbers[r]) r = mid;
        }
        return numbers[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}