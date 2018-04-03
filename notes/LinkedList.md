# 简介
* 插入节点
    * 指定位置增加节点：
* 删除节点
    * 删除指定值的节点：[203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
    * 删除重复节点：  
    [83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)  
    [82. Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
    * 删除当前节点：[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)
    * 删除倒数第N个节点：[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)
* 修改节点
    * 交换相邻节点的值：[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)
* 查找节点
    * 顺序查找：
    * O(n)时间内查找单链表的中间节点：
    * 逆序（从尾至头）输出单链表：
    * 输出倒数第K个节点：
* 反转链表（kGroup、Between）
    * 旋转链表：[61. Rotate List](https://leetcode.com/problems/rotate-list/)  
    * 反转链表：  
    [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)  
    [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)
    * 反转链表（每k个一组）：[25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group)
* 排序链表、合并链表
    * 排序链表（插入排序，归并排序，快排）：[148. Sort List](https://leetcode.com/problems/sort-list/)
    * 链表的插入排序：[147. Insertion Sort List](https://leetcode.com/problems/insertion-sort-list)
    * 合并两个排序单链表：[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)
    * 合并k个排序单链表：[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
    * 排序链表变成二叉搜索树：[109. Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
* 拆分链表（奇偶分开、以某个参考值分区）
    * 划分链表：[86. Partition List](https://leetcode.com/problems/partition-list/)
    * 奇偶链表：[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
* 环
    * 判断链表是否有环：[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
    * 找到环中第一个节点：[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
* 其他
    * 两个链表对应元素相加（进位）：  
    [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)  
    [445. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)
    * 深拷贝链表（random指针）：[138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)
    * 判断两个链表是否相交：[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)
    * 回文链表：[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
    * 把链表重新连接成要求的结果：[143. Reorder List](https://leetcode.com/problems/reorder-list/)

# 反转链表
链表的基本形式是：1 -> 2 -> 3 -> null，反转需要变为 3 -> 2 -> 1 -> null。这里要注意：
访问某个节点 curt.next 时，要检验 curt 是否为 null。
要把反转后的最后一个节点（即反转前的第一个节点）指向 null。

```
public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

# 删除链表中的某个节点
[如何删除单链表的头元素结点？](http://bbs.csdn.net/topics/390423332)  
[删除单链表某个结点（Java 版）](http://blog.csdn.net/lavor_zl/article/details/42803431)

删除链表中的某个节点一定需要知道这个点的前继节点，所以需要一直有指针指向前继节点。

然后只需要把 prev -> next = prev -> next -> next 即可。但是由于链表表头可能在这个过程中产生变化，导致我们需要一些特别的技巧去处理这种情况。就是下面提到的 Dummy Node。

# 链表指针的鲁棒性
综合上面讨论的两种基本操作，链表操作时的鲁棒性问题主要包含两个情况：
* 当访问链表中某个节点 curt.next 时，一定要先判断 curt 是否为 null。
* 全部操作结束后，判断是否有环；若有环，则置其中一端为 null。

# Dummy Node
Dummy node 是一个虚拟节点，也可以认为是标杆节点。Dummy node 就是**在链表表头 head 前加一个节点指向 head**，即 `dummy -> head`。Dummy node 的使用多针对单链表没有前向指针的问题，**保证链表的 head 不会在删除操作中丢失**。

除此之外，还有一种用法比较少见，就是**使用 dummy node 来进行 head 的删除操作**，比如 Remove Duplicates From Sorted List II，一般的方法 `cur = cur.next` 是无法删除 head 元素的，所以这个时候如果有一个 dummy node 在 head 的前面。

所以，**当链表的 head 有可能变化（被修改或者被删除）时**，使用 dummy node 可以很好的简化代码，最终返回 dummy.next 即新的链表。

主要的技巧就是要用 dummy head，就是在链表头加一个节点指向 head，这样可以避免判断头指针，统一处理所有情况，最后返回 `dummy->next`；另外有一个跟 dummy head 等价的方法是用指针的指针 `**p` 去处理，也能达到 dummy head 的效果，比 dummy 好的地方是，不用 delete dummy head，另外如果一个节点比较大的话，用 `**p` 也比较省空间，但是逻辑上比 dummy 要绕一点。

```java
//dummy head 的使用示例  
ListNode ProcessList(ListNode head){
    ListNode dummy = new ListNode();
    dummy.next = head;
    //process the list  
    head = dummy.next;
    delete dummy;// 再提醒一次，请记得 delete  
    return head;
}

// 指针的指针用法示例  
ListNode ProcessList(ListNode head){
    ListNode pNode = head;
    //process the list  
    // 每次将处理得到的 pCur 连到新链表 pNode 上  
    return head;
}
```

# 快慢指针
快慢指针也是一个可以用于很多问题的技巧。所谓快慢指针中的快慢指的是指针向前移动的步长，每次移动的步长较大即为快，步长较小即为慢，常用的快慢指针一般是在单链表中让快指针每次向前移动 2，慢指针则每次向前移动 1。快慢两个指针都从链表头开始遍历，于是快指针到达链表末尾的时候慢指针刚好到达中间位置，于是可以得到中间元素的值。快慢指针在链表相关问题中主要有两个应用：
* 快速找出未知长度单链表的中间节点：设置两个指针 *fast、*slow 都指向单链表的头节点，其中*fast的移动速度是*slow的 2 倍，当*fast指向末尾节点的时候，slow正好就在中间了。
* 判断单链表是否有环：利用快慢指针的原理，同样设置两个指针 *fast、*slow 都指向单链表的头节点，其中 *fast的移动速度是*slow的 2 倍。如果 *fast = NULL，说明该单链表 以 NULL结尾，不是循环链表；如果 *fast = *slow，则快指针追上慢指针，说明该链表是循环链表。



# 题目解析
## 删除节点
### Remove Linked List Elements
#### 题目描述
Remove all elements from a linked list of integers that have value val.

#### 思路
单链表每个结点只能引用下一个结点，因此删除结点时，也只能立足于一个不需要被删除的结点，去判断是否需要删除下一个结点。
由于删除时候需要遍历链表，但遍历的开始必须是头结点，而头结点如果要删除就要额外处理了。这里我们在头结点之前再插入一个临时结点，以统一处理整个链表。

#### 代码
```java
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null) {
        if (head.next.val == val) {
            head.next = head.next.next;
        } else {
            head = head.next;
        }
    }
    return dummy.next;
}
```

### Remove Duplicates from Sorted List
#### 题目描述

#### 思路

#### 代码
```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode cur = head;
    while (cur.next != null) {
        if (cur.val == cur.next.val) {
            cur.next = cur.next.next;
        } else {
            cur = cur.next;
        }
    }
    return head;
}
```

### Remove Duplicates from Sorted List II
#### 题目描述
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

#### 思路

#### 代码
```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;

    while (head.next != null && head.next.next != null) {
        if (head.next.val == head.next.next.val) {
            int duplicate = head.next.val;
            while (head.next != null && head.next.val == duplicate) {
                head.next = head.next.next;
            }
        } else {
            head = head.next;
        }
    }

    return dummy.next;
}
```

### Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list
#### 题目描述

#### 思路

#### 代码
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n <= 0) return null;

    // 设立头结点
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // 初始化slow,fast
    ListNode slow = dummy, fast = dummy;

    // fast指针先走n步
    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }
    // 两个指针同时移动直到p2到达最后
    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
    // 删除并返回
    slow.next = slow.next.next;
    return dummy.next;
}
```


### Delete Node in a Linked List
#### 题目描述

#### 思路

#### 代码
```java

```

### 
#### 题目描述

#### 思路

#### 代码
```java

```

# 参考资料
* [LeetCode Linked List 问题总结](https://blog.wqlin.me/2017/03/23/leetcode-linked-list-summary/)
* [leetcode 每题整理-爱做饭的小莹子](http://www.cnblogs.com/springfor/category/596835.html)  
* [gaven 的博客](http://blog.csdn.net/y999666/article/category/6162390)  
* [leetcode 总结无止境系列之链表](http://blog.csdn.net/chencheng126/article/details/39029889)
* [链表总结](http://ryanleetcode.blogspot.jp/2015/06/blog-post.html?m=1)  
* 
* 
* 
* 