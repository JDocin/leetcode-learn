//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 362 👎 0

package leetcode.editor.cn;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.*;
// Java：矩阵中的路径
class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return false;
        int n = board.length-1;
        int m = board[0].length-1;
        if (n == 0 && m == 0 && word.length() == 1) {
            return word.charAt(0) == board[0][0];
        }
        else if (n == 0 && m == 0 && word.length() > 1) return false;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] isUsed = new boolean[n+1][m+1];
                    if (findWord(word,i,j,0,board,isUsed)) return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(String s, int x, int y, int k, char[][] board, boolean[][] use){
        int n = board.length-1;
        int m = board[0].length-1;
        if (x<0||x>n||y<0||y>m||s.charAt(k)!=board[x][y]||use[x][y]==true) return false;
        if (s.charAt(k) == board[x][y] && use[x][y]==false && k == s.length()-1) {
            return true;
        }
        use[x][y] = true;
        boolean res =  findWord(s,x-1,y,k+1,board,use)||findWord(s,x+1,y,k+1,board,use)||findWord(s,x,y-1,k+1,board,use)||findWord(s,x,y+1,k+1,board,use);
        if (res) return true;
        else {
            use[x][y] = false;
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}