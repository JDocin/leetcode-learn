# [剑指 Offer 16. 数值的整数次方](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)
***
### 思路一：递归
递归是比较好理解的
1. 如果n == 0，返回1
2. 如果n < 0，最终结果为 *1/x^{-n}*
3. 如果n为奇数，最终结果为 *x * x ^ {n - 1}*
4. 如果n为偶数，最终结果为 *x ^ {2*(n/2)}*
> Java中因为n的最小值可以取到Integer.MIN_VALUE，如果直接取它的相反数的话还是它自己，会导致堆栈溢出，因此提一个x出来，具体看代码
### 代码
```Python3 []
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        elif n < 0:
            return 1/self.myPow(x, -n)
        elif n & 1:
            return x * self.myPow(x, n - 1)
        else:
            return self.myPow(x*x, n // 2)
```
```Java []
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1 / (x * myPow(x, - n - 1));
        }else if(n % 2 == 1){
            return x * myPow(x, n - 1);
        }else{
            return myPow(x * x, n / 2);
        }     
    }
}
```

**复杂度分析**
>递归几次就有多大的复杂度，最多递归次数是n为负数且n为奇数的时候，比n为正数且为偶数的情况多递归2次，常数级别的复杂度忽略不计；主要就看n为偶数的时候，这时最多递归次数为n的二进制位数，也就是*logn*(底数为2)。时空复杂度差不多是这个水平
- 时间复杂度：*O(logn)*
- 空间复杂度：*O(logn)*
***
### 思路二：迭代
1. 首先处理一下n为负数的情况，把x取一下倒数并且把n变为正数即可

2. 接下来以n = 18为例解释一下迭代的过程
*18 的二进制数为 0b10010（0b开头表示二进制数）*
*x ^ {18} = x ^ {16} * x ^ 2 = x ^ {0b10000} * x ^ {0b10}*
*令循环体为 x *= x，n >>= 1*
*循环1次可以得到x ^ 2*
*循环2次的时候n为奇数，把这个x ^ 2 乘到结果中*
*循环4次可以得到 x ^ {16}*
*循环5次的时候n为奇数，把x ^ {16}乘到结果中*
*也就是n的二进制数中有几个1就会乘几次，且乘数在循环中一次一次倍增*
> 这里也是因为Java会溢出的问题，用一个long类型的变量b来代替n

### 代码
```Python3 []
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = - n
        res = 1
        while n:
            if n & 1:
                res *= x
            n >>= 1
            x *= x
        return res
```

```Java []
class Solution {
    public double myPow(double x, int n) {
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = - b;
        }
        double res = 1;
        while(b != 0){
            if(b % 2 != 0){
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }
}
```

**复杂度分析**
- 时间复杂度：*O(logn)*
- 空间复杂度：*O(1)*