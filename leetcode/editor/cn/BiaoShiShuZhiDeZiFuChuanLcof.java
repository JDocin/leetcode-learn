//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 


package leetcode.editor.cn;

import java.util.*;
// Java：表示数值的字符串
public class BiaoShiShuZhiDeZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        // TO TEST
        System.out.println(solution.isNumber(".1-"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        s = s.replace((char) 12288, ' ');
        s = s.trim();
        if (s.length() == 0) return false;
        boolean havee = false;
        boolean haveoint = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Character.isDigit(c)){
                if (s.length()==1) return false;
                switch (c) {
                    case '+' :
                        if (i==s.length()-1) return false;
                        if(i!=0&&s.charAt(i-1)!='e'&&s.charAt(i-1)!='E') return false;
                        break;
                    case '-' :
                        if (i==s.length()-1) return false;
                        if(i!=0&&s.charAt(i-1)!='e'&&s.charAt(i-1)!='E') return false;
                        break;
                    case 'e' :
                        if(i==0||i==s.length()-1||havee||!Character.isDigit(s.charAt(i-1))) return false;
                        havee = true;
                        break;
                    case 'E' :
                        if(i==0||i==s.length()-1||havee||!Character.isDigit(s.charAt(i-1))) return false;
                        havee = true;
                        break;
                    case '.':
                        if(havee||haveoint|| (i!=0&&!Character.isDigit(s.charAt(i-1))&&s.charAt(i-1)!='-'&&s.charAt(i-1)!='+') ) return false;
                        haveoint = true;
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}