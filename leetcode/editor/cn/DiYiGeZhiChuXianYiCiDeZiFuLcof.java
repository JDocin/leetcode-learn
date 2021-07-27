//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 118 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：第一个只出现一次的字符
public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int minPos = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i),s.length());
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            minPos = Math.min(minPos, entry.getValue());
        }
        return minPos == s.length()?' ':s.charAt(minPos);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}