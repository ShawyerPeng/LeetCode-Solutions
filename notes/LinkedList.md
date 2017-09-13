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

# Dummy Node
Dummy node 是一个虚拟节点，也可以认为是标杆节点。Dummy node 就是**在链表表头 head 前加一个节点指向 head**，即 `dummy -> head`。Dummy node 的使用多针对单链表没有前向指针的问题，**保证链表的 head 不会在删除操作中丢失**。

除此之外，还有一种用法比较少见，就是**使用 dummy node 来进行 head 的删除操作**，比如 Remove Duplicates From Sorted List II，一般的方法 `cur = cur.next` 是无法删除 head 元素的，所以这个时候如果有一个 dummy node 在 head 的前面。

所以，**当链表的 head 有可能变化（被修改或者被删除）时**，使用 dummy node 可以很好的简化代码，最终返回 dummy.next 即新的链表。

# 快慢指针
快慢指针也是一个可以用于很多问题的技巧。所谓快慢指针中的快慢指的是指针向前移动的步长，每次移动的步长较大即为快，步长较小即为慢，常用的快慢指针一般是在单链表中让快指针每次向前移动 2，慢指针则每次向前移动 1。快慢两个指针都从链表头开始遍历，于是快指针到达链表末尾的时候慢指针刚好到达中间位置，于是可以得到中间元素的值。快慢指针在链表相关问题中主要有两个应用：
* 快速找出未知长度单链表的中间节点：设置两个指针 *fast、*slow 都指向单链表的头节点，其中*fast的移动速度是*slow的 2 倍，当*fast指向末尾节点的时候，slow正好就在中间了。
* 判断单链表是否有环：利用快慢指针的原理，同样设置两个指针 *fast、*slow 都指向单链表的头节点，其中 *fast的移动速度是*slow的 2 倍。如果 *fast = NULL，说明该单链表 以 NULL结尾，不是循环链表；如果 *fast = *slow，则快指针追上慢指针，说明该链表是循环链表。










# 参考资料
[leetcode 每题整理-爱做饭的小莹子](http://www.cnblogs.com/springfor/category/596835.html)  
[gaven 的博客](http://blog.csdn.net/y999666/article/category/6162390)  

[链表总结](http://ryanleetcode.blogspot.jp/2015/06/blog-post.html?m=1)  
