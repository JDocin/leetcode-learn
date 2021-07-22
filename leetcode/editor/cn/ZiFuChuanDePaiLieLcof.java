//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 383 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：字符串的排列
public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
        System.out.println(solution.permutation("aab"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    public String[] permutation(String s) {
        if (s.isEmpty()) return null;
        char[] arr= s.toCharArray();
        boolean[] iswalk = new boolean[arr.length];
        backtrace(arr,iswalk);
        return res.toArray(new String[res.size()]);
    }

    // 属于需要去重的全排列，在横向去重，竖向可以有重复的，所以在当前循环最后加入set，而不是递归之前
    public void backtrace (char[] arr, boolean[] iswalk) {
        if (str.length() == arr.length) res.add(str.toString());
        Set<Character> set = new HashSet<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (!iswalk[i]&&!set.contains(arr[i])) {
                str.append(arr[i]);
                iswalk[i] = true;
                backtrace(arr, iswalk);
                str.deleteCharAt(str.length() - 1);
                iswalk[i] = false;
                set.add(arr[i]);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}