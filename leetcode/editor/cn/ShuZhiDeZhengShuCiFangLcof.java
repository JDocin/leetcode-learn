//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 
// 👍 177 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：数值的整数次方
public class ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        // TO TEST
        //System.out.println(solution.myPow(2.00000,-4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution1 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1 / (x * myPow(x, - n - 1));
        }else if(n % 2 == 1){
            return x * myPow(x, n - 1);
        }else{
            return myPow(x * x, n / 2);
        }
    }
}
class Solution {
    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        // 第一层循环，控制的是位数1-n位
        for(int digit = 1; digit < n + 1; digit++){
            //第二层控制的是第一位，为了排除0开头的情况，限制每轮首位都是1-9开头
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first; // first是首位的意思
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}