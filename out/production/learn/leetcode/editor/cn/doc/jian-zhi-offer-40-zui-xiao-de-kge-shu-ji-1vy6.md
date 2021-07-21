### 解题思路
看到这个算法题目时，我的思路是先把整数数组利用排序算法（冒泡排序；插入排序；快速排序等等）从小到大排序，再返回有序数组的前K个元素组成的新数组即可

注意：java中排序可以直接使用Array的sort方法，也可以使用java提供数组API提高算法运行效率

### 代码

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
       int[] arr1 = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            arr1[i] = arr[i];
         }
        return arr1;
    }
}
```