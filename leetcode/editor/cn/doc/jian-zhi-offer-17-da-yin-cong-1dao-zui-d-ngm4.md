# [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)
***
### 思路一：普通解法
看到返回int数组的时候我也挺懵的，这题考查的实际是大数问题
那不管三七二十一，先上一个不考虑大数的解法吧

步骤：
1. 枚举从 *1* 到 *10^n - 1*
2. 返回int数组
### 代码
```Python3 []
class Solution:
    def printNumbers(self, n: int) -> List[int]:
        return [i for i in range(1, 10**n)]
```

```Java []
class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10, n) - 1];
        for(int i = 0; i < res.length; i++){
            res[i] = i + 1;
        }
        return res;
    }
```

**复杂度分析**
- 时间复杂度：*O(10 ^ n)*
- 空间复杂度：算上返回值 *O(10 ^ n)* 不算返回值 *O(1)*
***
### 思路二：全排列解法
在数字很大的情况下，哪怕long类型也无法承载，那必须要用字符串保存。
对于本题其实就是对数字0~9的**全排列**，从1位数0~9的全排列到n位数0~9的全排列，其中要注意的是数字开头不应该有0。
>简单提一下全排列，比如对于数字1，2，3的全排列是:
```
123, 132, 213, 231, 312, 321
```
**为了能够测试通过**，最后把字符串形式变成了int形式，其实应该返回字符串数组

以下是具体步骤
1. 为了避免数字开头出现0，先把首位first固定，first取值范围为1~9
2. 用digit表示要生成的数字的位数，本题要从1位数一直生成到n位数，对每种数字的位数都生成一下首位，所以有个双重for循环
3. 生成首位之后进入递归生成剩下的digit - 1位数，从0~9中取值
4. 递归的中止条件为已经生成了digit位的数字，即index == digit，将此时的数num转为int加到结果res中


### 代码
```Python3 []
class Solution:
    def printNumbers(self, n: int) -> List[int]:
        def dfs(index, num, digit):
            if index == digit:
                res.append(int(''.join(num)))
                return
            for i in range(10):
                num.append(str(i))
                dfs(index + 1, num, digit)
                num.pop()

        res = []
        for digit in range(1, n + 1):
            for first in range(1, 10):
                num = [str(first)]
                dfs(1, num, digit)
        
        return res
```

```Java []
class Solution {
    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        for(int digit = 1; digit < n + 1; digit++){
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }
}
```

**复杂度分析**
- 时间复杂度：*O(10^n)*，从 *1* 到 *10 ^n - 1* 的数肯定都遍历了一遍
- 空间复杂度：*O(n)*，空间复杂度度主要在递归栈以及num数组这里，递归的最大深度和数组的最大长度都为n；算返回值的话为O*(10^n)*