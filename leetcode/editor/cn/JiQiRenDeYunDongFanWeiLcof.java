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
// 广度优先
    class Solution0 {
        public int movingCount(int m, int n, int k) {
            boolean[][] check = new boolean[m][n];
            int res = 1;
            check[0][0] = true;
            for (int i = 0; i < m && (i/10+i%10)<=k; i++) {
                for (int j = 0; j < n && (j/10+j%10)<=k; j++) {
                    //for里的限制条件，只能用最大范围的，不能加i，不然有可能漏算，因为可以从上层/下层过来
                    //而只加当变量i/j的话，说明即使另一个坐标=0，也走不过去，这一排都是黑的，没有可以跳过的。
                    if(check[i][j]) {
                        //走过一个已经能走的（true）,查看它周围的能不能走
                        if(isWalk(check,i-1,j,k)) res++;
                        if(isWalk(check,i+1,j,k)) res++;
                        if(isWalk(check,i,j-1,k)) res++;
                        if(isWalk(check,i,j+1,k)) res++;
                    }
                }
            }
            return res;
        }

        public boolean isWalk(boolean[][] check, int x, int y, int k){
            int count =  x/10 + x%10 + y/10 + y%10;
            if (x<0||x>=check.length||y<0||y>check[0].length||check[x][y]||count>k) return false;
            check[x][y] = true;
            return true;
        }
    }

    // 广度
    class Solution {
        public int movingCount(int m, int n, int k) {
            if (k==0) return 1;
            boolean[][] check = new boolean[m][n];
            check[0][0] = true;
            int res=1;
            for (int i = 0; i < m && (i/10+i%10)<=k; i++) {
                for (int j = 0; j < n && (j/10+j%10)<=k; j++) {
                    int count = i/10 + i%10 + j/10 + j%10;
                    if(!check[i][j] && count<=k) {
                        if(walk(check,i,j)){
                            //f[count] += 1;
                            res++;
                            check[i][j] = true;
                        }
                    }
                }
            }
            return res;
        }

        public boolean walk(boolean [][]check, int i, int j){
            if(i-1>=0&&check[i-1][j]) return true;
            if(i+1<check.length&&check[i+1][j]) return true;
            if(j-1>=0&&check[i][j-1]) return true;
            if(j+1<check[0].length&&check[i][j+1]) return true;
            return false;
        }
    }

    // 深度
    class Solution2 {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m, n, k, visited);
        }

        private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
            if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                    dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}