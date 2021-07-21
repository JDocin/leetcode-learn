//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 276 👎 0

package leetcode.editor.cn;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
// Java：顺时针打印矩阵
public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) throws ParseException {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TO TEST
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
//        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//
//        Date date = new Date();
//
//        Integer time = Integer.valueOf(dateFormat.format(date));
//
//        System.out.println(time.getClass());

//        DateFormat dft = new SimpleDateFormat("yyyyMMdd");
//        Date beginDate = new Date();
//        Calendar date = Calendar.getInstance();
//        date.setTime(beginDate);
//        date.set(Calendar.DATE, date.get(Calendar.DATE) - 3);
//        String endDate = dft.format(date.getTime());
//        System.out.println(endDate);

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
        int[] res = new int[(right+1)*(down+1)];
        for (int t = 0,i,j; t < res.length; ) {
            for (i=up, j=left; j <= right&&t < res.length ; j++) {
                System.out.println(matrix[i][j]);
                res[t++] = matrix[i][j];
            }
            up++;
            j=right;
            for (i = up; i <= down&&t < res.length; i++) {
                System.out.println(matrix[i][j]);
                res[t++] = matrix[i][j];
            }
            right--;
            i=down;
            for (j=right; j>=left&&t < res.length; j--) {
                System.out.println(matrix[i][j]);
                res[t++] = matrix[i][j];
            }
            down--;
            j=left;
            for (i = down; i >= up&&t < res.length; i--) {
                System.out.println(matrix[i][j]);
                res[t++] = matrix[i][j];
            }
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}