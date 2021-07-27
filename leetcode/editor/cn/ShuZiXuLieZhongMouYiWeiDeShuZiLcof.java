//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 
// 👍 150 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：数字序列中某一位的数字
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        // TO TEST
        System.out.println(solution.findNthDigit(30));
        System.out.println(solution.findNthDigit(29));
        System.out.println(solution.findNthDigit(11));
        System.out.println(solution.findNthDigit(10));
        System.out.println(solution.findNthDigit(100));
        System.out.println(solution.findNthDigit(1000));

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long digitNum = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;  //数位长度len
            digitNum *= 10; //该数位下 每组的个数（10，100，1000...)
            count = digit * digitNum * 9;
        }
        long num = digitNum + (n - 1) / digit;  // 数位基底 + n/len取整（结果位于该基底的第几个数内）
        return Long.toString(num).charAt((n - 1) % digit) - '0'; //该数字取余的位置，就是结果
    }
}
class Solution1 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        n-=9;
        int m = 1;
        int pos = 10;
        while ((m+1)*9*Math.pow(10,m) < n) {
            n -= (m+1)*9*Math.pow(10,m);
            pos += (m+1)*9*Math.pow(10,m);
            m++;
        }
        int pre = (int) (n/((m + 1)*Math.pow(10,m)));
        int cur = (int) (n%((m + 1)*Math.pow(10,m)));
        if (cur==0) {
            cur = (int) ((m + 1)*Math.pow(10,m));
            pre--;
        }
        int begin = pos;
        if (pre > 0) {
            begin += pre * Math.pow(10,m);
        }
        StringBuilder str = new StringBuilder();
        for (int i=0; i <= cur; ) {
            str.append(begin);
            i+=(m+1);
            begin++;
        }
        char res = str.charAt(cur-1);
        return (int) (res - '0');
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}