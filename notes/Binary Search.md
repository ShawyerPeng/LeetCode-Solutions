# 简介



# 使用场景
* 有序数组
* O(logn)的时间复杂度

# 二分法模板的四点要素
* start + 1 < end
* start + (end - start) / 2，可以避免 (start + end) / 2, 可能造成的溢出
* A[mid] ==, <, >，三种情况先分开考虑，写完后也许可以合并. 范围缩小要用 start = mid 或 end = mid
* A[start] A[end] ? target，当循环结束的时候，并不能确定 start, end 到底哪个是所求解，要分别判断

# 二分法关键
* 头尾指针，取中点，判断往哪儿走
* 寻找满足某个条件第一个或是最后一个位置
* 保留剩下来一定有解的那一半

# 两类二分法
二分位置 Binary Search on index
二分答案 Binary Search on result

# 理解二分法的三个层次
* 头尾指针，取中点，判断往哪走
* 寻找满足某个条件的第一个或是最后一个位置
* 保留剩下来一定有解的那一半

# 题目类型
* Binary Search Template
* Rotated Sorted Array
    * Find Minimum
    * Find Target
    * Why O(n) with duplicates?
* Find Median in Two Sorted Array
* Reverse in 3 Steps

# 实现方式
尽量用非递归方法写。如果用递归方法写简单很多，就用递归方法
* 递归
* while

# 二分法搜索模板
为什么不是(end-start+1)/2？
这样不等价于(start+end)/2

为什么不是(start+end+1)/2？
取偏左一点的位置

为什么mid不能+-1？
没有说不能，有的题可以，有的题不可以
```java
if (nums[mid] == target)    // 前面可能还有一个相等的数
    end = mid;
```
这里就不能，因为mid等于的时候就不能+-1


找first index in this number
```java
public static int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)  return -1;

    int start = 0;
    int end = nums.length - 1;

    while (start + 1 < end) {   // start和end相邻或相交，在任何情况下都不会死循环
        // 这样写不会有溢出的情况
        int mid = start + (end - start) / 2;
        // 如果start + end是一个接近于MAXINT的数，会溢出
        // mid = (start + end) / 2;
        if (nums[mid] == target)    // 前面可能还有一个相等的数
            end = mid;
        else if (nums[mid] < target)
            start = mid;
        else if (nums[mid] > target)
            end = mid;
    }

    // 再做一层判断，判断取得的是第一个还是第二个
    if (nums[start] == target)
        return start;
    if (nums[end] == target)
        return end;

    return -1;
}
```

## first index
```java
public static int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)  return -1;

    int start = 0;
    int end = nums.length - 1;

    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            end = mid;
        else if (nums[mid] < target)
            start = mid;
        else if (nums[mid] > target)
            end = mid;
    }

    if (nums[start] == target)
        return start;
    if (nums[end] == target)
        return end;

    return -1;
}
```
## last index
若找last index，则要先判断end
```java
public static int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)  return -1;

    int start = 0;
    int end = nums.length - 1;

    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            start = mid;
        else if (nums[mid] < target)
            start = mid;
        else if (nums[mid] > target)
            end = mid;
    }

    if (nums[end] == target)
        return end;
    if (nums[start] == target)
        return start;

    return -1;
}
```

# O(log(n)的算法
* 二分法
* 倍增法




# 参考资料
[算法之美——二分法](https://blog.bcmeng.com/post/binarysearch.html)  
[一起 lintcode ------- 二分查找看这篇就够了](http://community.bittiger.io/topic/241/%E4%B8%80%E8%B5%B7lintcode-%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E7%9C%8B%E8%BF%99%E7%AF%87%E5%B0%B1%E5%A4%9F%E4%BA%86)  
[LintCode 二分查找题总结](http://blog.csdn.net/luoshengkim/article/details/52103427)  
[LeetCode-Binary-Search](http://52.14.116.56/2017/08/23/LeetCode/LeetCode-Binary-Search/)  
[Binary Search](https://lefttree.gitbooks.io/leetcode-categories/BinarySearch/binarySearch.html)  
[关于二分查找 (Binary Search) 及其变种形式的总结](https://simpleandstupid.com/2014/12/23/%E5%85%B3%E4%BA%8E%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E7%9A%84%E6%80%BB%E7%BB%93/)  
[Binary Search 二分查找总结](http://pengmeng.me/2016/03/07/binary-search-note.html)  
[Binary Search(二分搜索) 总结](https://dyang2016.wordpress.com/2016/11/07/binary-search%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E6%80%BB%E7%BB%93/)  
[漫谈二分查找 - Binary Search](http://duanple.blog.163.com/blog/static/709717672009049528185/)  
[数组中的二分法查找](http://www.jianshu.com/p/7c17cc56e21e)  
[binary search 及扩展出来的几个问题讨论](http://shmilyaw-hotmail-com.iteye.com/blog/1626910)  
[二分查找有几种写法？它们的区别是什么？](https://www.zhihu.com/question/36132386)  
[把二分查找算法写正确需要注意的地方](http://www.cppblog.com/converse/archive/2009/09/21/96893.aspx)  
[二分搜索总结 - Kevin's Destiny](https://yunpengxiao.wordpress.com/2016/01/30/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2/)  
