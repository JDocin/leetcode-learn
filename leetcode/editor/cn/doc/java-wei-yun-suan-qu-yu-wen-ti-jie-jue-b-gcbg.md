### 解题思路
本题解借鉴了 **题解区**大佬 的思想：
> 1. 申请一个长度为32的int数组，用于记录 **数组中所有数字** 的 **每一位的和**
> 
> 2. 遍历nums数组中的每一个数字：
>> 由高到低，遍历当前数字的每一位，
>> 若 当前位为1，则使bitSumArray数组的相应的单元的值+1
> 
> 3. 根据步骤(2) 计算结果：
>> 遍历bitSumArray数组的每一位，取每一位和3取余的结果（肯定为0或1）
>> 并将其 加入到 结果result的适当位上

### 运行结果
![image.png](https://pic.leetcode-cn.com/1614393413-BGfxEs-image.png)

### 代码

```java
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int[] bitSumArray = new int[32];    // 用于记录 数组中所有数字 的 每一位的和
        for (int num : nums) {
            /*
                由高到低，遍历当前数字的每一位，
                若 当前位为1，则使bitSumArray数组的相应的单元的值+1
            */
            int curBit = 1;
            for (int i = 31; i >= 0; i--) {
                if ((curBit & num) != 0) {
                    bitSumArray[i]++;
                }
                curBit <<= 1;
            }
        }

        /*
            计算结果：
                遍历bitSumArray数组的每一位，取每一位和3取余的结果（肯定为0或1）
                并将其 加入到 结果result的适当位上
        */
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitSumArray[i] % 3;
        }

        return result;
    }
}
```
打卡177天，加油！！！
越来越发现自己的无知，感觉蛮好的，
目标定下来，追就完事了，加油！！！💪