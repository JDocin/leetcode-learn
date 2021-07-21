//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 271 👎 0

package leetcode.editor.cn;
import java.util.*;
// Java：最小的k个数
public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
        solution.getLeastNumbers(new int[]{5,1,2,7,3,5,4,6},3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0) return new int[0];
        else if(k >= arr.length) return arr;
        Queue<Integer> q = new PriorityQueue<>((x,y)->(y-x));
        for (int i = 0; i < arr.length; i++) {
            if(q.size()<k) {
                q.offer(arr[i]);
            } else if(q.size()==k && q.peek()>arr[i]){
                q.poll();
                q.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        while (!q.isEmpty()) res[--k] = q.poll();
        return res;
    }
}
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0) return new int[0];
        else if(k >= arr.length) return arr;
        return findk(arr,k,0,arr.length-1);
    }

    public int[] findk(int[] arr,int k,int l,int r) {
        int pos = quicksort(arr, l, r);
        if (pos == k) {
            return Arrays.copyOf(arr, k);
        } else if (pos < k) {
            return findk(arr, k, pos + 1, r);
        } else {
            return findk(arr, k, l, pos - 1);
        }
    }

    public int quicksort(int [] arr, int l, int r) {
        int tmp = arr[l];
        while (l<r) {
            while (r>l && arr[r]>=tmp) r--;
            arr[l] = arr[r];
            while (l<r && arr[l]<=tmp) l++;
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}