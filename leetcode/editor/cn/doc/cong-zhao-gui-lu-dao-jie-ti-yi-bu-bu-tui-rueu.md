* 发现自己写完和K神的思路几乎是一模一样
![剑指offer图解.png](https://pic.leetcode-cn.com/1617936442-AIJyZM-%E5%89%91%E6%8C%87offer%E5%9B%BE%E8%A7%A3.png)

```java []
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long digitNum = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            digitNum *= 10;
            count = digit * digitNum * 9;
        }
        long num = digitNum + (n - 1) / digit; 
        return Long.toString(num).charAt((n - 1) % digit) - '0'; 
    }
}
```
```python []
class Solution:
    def findNthDigit(self, n: int) -> int:
        digit, digitNum, count = 1, 1, 9
        while n > count: 
            n -= count
            digit += 1
            digitNum *= 10
            count = 9 * digit * digitNum
        num = digitNum + (n - 1) // digit 
        index = (n-1)%digit
        return int(str(num)[index])
```
```golang []
func findNthDigit(n int) int {
    digit,digitNum,count := 1,1,9
    for n>count{
        n -= count
        digit++
        digitNum *= 10
        count = 9*digit*digitNum
    }
    num := digitNum + (n-1)/digit

    index := (n-1)%digit

    numStr := strconv.Itoa(num)
    return int(numStr[index]-'0')
}
```
