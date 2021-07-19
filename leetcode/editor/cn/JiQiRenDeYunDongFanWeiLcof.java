//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 321 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：机器人的运动范围
class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        // TO TEST
        System.out.println(solution.movingCount(1,2,1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount1(int m, int n, int k) {
        if (k==0) return 1;
        int[] f = new int[k+1];
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < m && countNum(i,0)<=k; i++) {
            for (int j = 0; j < n && countNum(i,j) <=k ; j++) {
                f[countNum(i,j)] += 1;
            }
        }
        for (int i = 1; i <=k ; i++) {
            dp[i] = dp[i-1] + f[i];
            System.out.println(f[i]);
        }
        return dp[k];
    }


    public int movingCount(int m, int n, int k) {
        if (k==0) return 1;
        boolean[][] isWalk = new boolean[m][n];
        int[] f = new int[k+1];
        int[] dp = new int[k+1];
        dp[0] = 1;
        isWalk[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!isWalk[i][j] && countNum(i,j)<=k) {
                    if(walk(isWalk,i,j)){
                        f[countNum(i, j)] += 1;
                        isWalk[i][j] = true;
                    }
                }
            }
        }
        for (int i = 1; i <=k ; i++) {
            dp[i] = dp[i-1] + f[i];
            System.out.println(f[i]);
        }
        return dp[k];
    }

    public int countNum(int x, int y){
        if (x<10&&y<10) {
            return x + y;
        }
        else if (x>=10&&y<10) {
            return y + x/10 + x%10;
        }
        else if (y>=10&&x<10) {
            return x + y/10 +y%10;
        }
        else {
            return x/10 + x%10 + y/10 + y%10;
        }
     }

     public boolean walk(boolean [][]check, int i, int j){
        if(i<0||i==check.length||j<0||j==check[0].length) return false;
        else {
            boolean res = walk(check,i-1,j)||walk(check,i+1,j)||walk(check,i,j-1)||walk(check,i,j+1);
            return res;
        }
     }

}
//leetcode submit region end(Prohibit modification and deletion)

}