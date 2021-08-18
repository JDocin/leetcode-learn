//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// Related Topics 字符串 动态规划 
// 👍 261 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：把数字翻译成字符串
public class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
        System.out.println(solution.translateNum(1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        String str = "12c14m";
        int index = str.indexOf('c');
        String cores = str.substring(0, index);
        System.out.println(cores);
        String memory = str.substring(index+1, str.length()-1);
        System.out.println(memory);
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}