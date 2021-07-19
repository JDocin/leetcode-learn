### 解题思路

**刚开始刷题，记录以下自己的做题思路以便后续复习！**

### 代码
**思路1.双指针法，边遍历边比较。**
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.new一个头节点。
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //2.用cur1、cur2分别指向l1、l2的首元节点，这样不会破坏原链表。
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //3.边遍历边比较。
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        //4.连接最后一个节点。
        if(cur1 == null) cur.next = cur2;
        else cur.next = cur1;
        return head.next;
    }
}
```
**思路2.递归法。**
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.递归结束的条件（这个条件能够直接得到递归结果）。
        //①这里最能直接得到结果的是l1 == null && l2 == null，因此刚开始可能结束条件只写了这一点。②但是当后面写出函数等价关系式后，要回过来检查是否有遗漏的条件。本题中：若传入函数的l1/l2仅有一个节点，则后面会报空指针异常，因此也要仅有一个节点的情况加到递归结束的条件中。
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        //2.函数等价关系式（这个关系式可以化简原函数关系式）。
        //①原关系式是：合并两个分别含有m、n个节点的排序链表。②等价关系式是：合并两个分别含有m-1、n或m、n-1个节点的排序链表+特殊处理减掉的那个节点。
        if(l1.val <= l2.val){
            head = l1;
            l1.next = mergeTwoLists(l1.next,l2);
        }else{
            head = l2;
            l2.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
}
```