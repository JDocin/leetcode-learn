//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 440 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：数组中数字出现的次数
public class ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
        List<List<String>> all = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add(1+"");
        list1.add(2+"");
        list1.add(3+"");

        list2.add(4+"");
        list2.add(5+"");
        list2.add(6+"");

        list3.add(7+"");
        list3.add(8+"");

        all.add(list1); all.add(list2); all.add(list3);
        List<List<String>> res = new ArrayList<>();

        solution.descartes(all,res,0,new ArrayList<>());
        System.out.println(res.toString());
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            //n = x^y; m = x和y最右边的不相等的二进制位置，如0010
            int x = 0, y = 0, n = 0, m = 1;
            for(int num : nums)               // 1. 遍历异或
                n ^= num;
            while((n & m) == 0)               // 2. 循环左移，计算 m
                m <<= 1;
            for(int num: nums) {              // 3. 遍历 nums 分组
                if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
                else y ^= num;                // 4. 当 num & m == 0
            }
            return new int[] {x, y};          // 5. 返回出现一次的数字
        }

//        public void descartes(int index, List<List<String>> all, List<String> temp, List<List<String>> res) {
//            List<String> list = all.get(index);
//            int allSize = all.size();
//            int removeCount = allSize - index ;
//            for (int i = 0; i < list.size(); i++) {
//                String value = list.get(i);
//                if (i > 0) {
//                    for (int j = 0; j < removeCount; j++) {
//                        temp.remove(temp.size() - 1);
//                    }
//                }
//
//                temp.add(value);
//
//                if (index == allSize - 1) {
//                    System.out.println(temp);
//                    res.add(new ArrayList<>(temp));
//                }
//
//                if (index < allSize - 1) {
//                    descartes(index + 1, all, temp, res);
//                }
//            }
//        }

        public <T> void descartes(List<List<T>> dimensionValue, List<List<T>> result, int layer, List<T> currentList) {
            if (layer < dimensionValue.size() - 1) {
                if (dimensionValue.get(layer).size() == 0) {
                    descartes(dimensionValue, result, layer + 1, currentList);
                } else {
                    for (int i = 0; i < dimensionValue.get(layer).size(); i++) {
                        List<T> list = new ArrayList<T>(currentList);
                        list.add(dimensionValue.get(layer).get(i));
                        descartes(dimensionValue, result, layer + 1, list);
                    }
                }
            } else if (layer == dimensionValue.size() - 1) {
                if (dimensionValue.get(layer).size() == 0) {
                    result.add(currentList);
                } else {
                    for (int i = 0; i < dimensionValue.get(layer).size(); i++) {
                        List<T> list = new ArrayList<T>(currentList);
                        list.add(dimensionValue.get(layer).get(i));
                        result.add(list);
                    }
                }
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}