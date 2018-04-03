# 简介



# 使用场景
* 有序数组
* O(logn)的时间复杂度



# 注意点
* 中间值取整方式：向下取整`left+(right-left)/2`, 向上取整`right-(right-left)/2`
* 区间开闭：闭区间`[left,right]`、左闭右开区间`[left,right)`、左开右闭区间`(left,right]`、开区间`(left,right)`
* 终止条件：区间长度为零`left<right`、区间长度为1`left+1<=right`（`left<=right`）
* 分半的时候取=`mid`, `mid-1`, or `mid+1`
* 问题类型
    * 对于不下降序列a，求最小的i，使得`a[i] = key`
    * 对于不下降序列a，求最大的i，使得`a[i] = key`
    * 对于不下降序列a，求最小的i，使得`a[i] > key`
    * 对于不下降序列a，求最大的i，使得`a[i] < key`

# 问题思考
## 何时该 return left;何时该 return right？



# 实现方式
尽量用非递归方法写。如果用递归方法写简单很多，就用递归方法
* 递归
* while

## 左闭右开

```java

```

## 左闭右闭
```java

```


# 边界错误造成的问题
二分查找算法的边界，一般来说分两种情况，一种是左闭右开区间，类似于[left, right)，一种是左闭右闭区间，类似于[left, right].需要注意的是，循环体外的初始化条件，与循环体内的迭代步骤，都必须遵守一致的区间规则，也就是说，如果循环体初始化时，是以左闭右开区间为边界的，那么循环体内部的迭代也应该如此.如果两者不一致，会造成程序的错误。比如下面就是错误的二分查找算法：
```java
int search_bad(int nums[], int target) {
    int left = 0, right = nums.length;
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```
这个算法的错误在于，在循环初始化的时候，初始化`right=n`，也就是采用的是**左闭右开**区间，而当满足`nums[mid] > target`的条件是，target如果存在的话应该在[left, mid)区间中，但是这里却把right赋值为mid-1了，这样，如果恰巧mid-1就是查找的元素，那么就会找不到这个元素。


```java
int search_bad(int nums[], int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            return mid;
        }
    }
    return -1;
}
```
这个程序采用的是左闭右闭的区间。但是，当`nums[mid] < target`的时候，那么下一次查找的区间应该为[mid + 1, right]，而这里变成了[mid, right];当`nums[mid] > target`的时候，那么下一次查找的区间应该为[left, mid - 1]，而这里变成了[left, mid]。两个边界的选择都出现了问题，因此，有可能出现某次查找时始终在这两个范围中轮换，造成了程序的死循环。

# 九章算法的二分法模板
## 二分法模板的四点要素
* start + 1 < end
* start + (end - start) / 2，可以避免 (start + end) / 2, 可能造成的溢出
* A[mid] ==, <, >，三种情况先分开考虑，写完后也许可以合并. 范围缩小要用 start = mid 或 end = mid
* A[start] A[end] ? target，当循环结束的时候，并不能确定 start, end 到底哪个是所求解，要分别判断

## 二分法关键
* 头尾指针，取中点，判断往哪儿走
* 寻找满足某个条件第一个或是最后一个位置
* 保留剩下来一定有解的那一半

## 两类二分法
二分位置 Binary Search on index
二分答案 Binary Search on result

## 理解二分法的三个层次
* 头尾指针，取中点，判断往哪走
* 寻找满足某个条件的第一个或是最后一个位置
* 保留剩下来一定有解的那一半

## Double型二分
while(fabs(right-left)>eps)//判断语句
注：1、right与left之差进行判断
    2、eps的值够精度，不然很容易wa

## 二分法搜索模板
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


# 题目类型
* Binary Search Template
* Search for a Range: 这道题需要终止条件`i<j`,mid取向两种都需要用到，分半的时候需要用到`=mid`。我发现一般`=mid`的时候，终止条件往往是`i<j`,不然会有死循环。
* Find Peak Element
* Find Minimum in Rotated Sorted Array
* Find Minimum in Rotated Sorted Array II
* Search Insert Position
* Search a 2D Matrix: 这是一道普通的binary search。终止条件i<=j,mid取向i+(j-i)/2, 分半的时候=mid-1 or mid+1。
* Rotated Sorted Array
    * Find Minimum
    * Find Target
    * Why O(n) with duplicates?
* Search in Rotated Sorted Array
* Search in Rotated Sorted Array II
* Median in Two Sorted Array
* Reverse in 3 Steps
* Word Break
* Gray Code
* Divide Two Integers
* Pow(x, n)
* Sqrt(x)

# 相关题目
## 374. Guess Number Higher or Lower
https://leetcode.com/problems/guess-number-higher-or-lower



# 参考资料
* [算法之美——二分法](https://blog.bcmeng.com/post/binarysearch.html)  
* [一起 lintcode ------- 二分查找看这篇就够了](http://community.bittiger.io/topic/241/%E4%B8%80%E8%B5%B7lintcode-%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E7%9C%8B%E8%BF%99%E7%AF%87%E5%B0%B1%E5%A4%9F%E4%BA%86)  
* [LintCode 二分查找题总结](http://blog.csdn.net/luoshengkim/article/details/52103427)  
* [LeetCode-Binary-Search](http://52.14.116.56/2017/08/23/LeetCode/LeetCode-Binary-Search/)  
* [Binary Search](https://lefttree.gitbooks.io/leetcode-categories/BinarySearch/binarySearch.html)  
* [关于二分查找 (Binary Search) 及其变种形式的总结](https://simpleandstupid.com/2014/12/23/%E5%85%B3%E4%BA%8E%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E7%9A%84%E6%80%BB%E7%BB%93/)  
* [Binary Search 二分查找总结](http://pengmeng.me/2016/03/07/binary-search-note.html)  
* [Binary Search(二分搜索) 总结](https://dyang2016.wordpress.com/2016/11/07/binary-search%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E6%80%BB%E7%BB%93/)  
* [漫谈二分查找 - Binary Search](http://duanple.blog.163.com/blog/static/709717672009049528185/)  
* [数组中的二分法查找](http://www.jianshu.com/p/7c17cc56e21e)  
* [binary search 及扩展出来的几个问题讨论](http://shmilyaw-hotmail-com.iteye.com/blog/1626910)  
* [二分查找有几种写法？它们的区别是什么？](https://www.zhihu.com/question/36132386)  
* [把二分查找算法写正确需要注意的地方](http://www.cppblog.com/converse/archive/2009/09/21/96893.aspx)  
* [二分搜索总结 - Kevin's Destiny](https://yunpengxiao.wordpress.com/2016/01/30/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2/)  
* [Leetcode 总结，二分法一般性总结](http://www.aizhuanji.com/a/7WMM0NaW.html)  
* [【九章算法基础班】二分法](https://siyaozhang.github.io/2017/12/07/【九章算法基础班】二分法)
* [LeetCode总结，二分法一般性总结](https://blog.csdn.net/ebowtang/article/details/50770315)
* [二分查找](https://github.com/acgtyrant/Algorithm-and-Data-Structure/wiki/二分查找)
* [二分法搜索小技巧](https://zhuanlan.zhihu.com/p/30261905)
* [问一个关于二分法的简单问题，何时该 return left;何时该 return right，谢谢！！！](https://bbs.csdn.net/topics/390807003)
* [二分查找的坑点与总结](https://blog.csdn.net/haolexiao/article/details/53541837)
* [二分查找实现细节](https://blog.csdn.net/hust_dxxxd/article/details/51030147)
* [二分查找各种情况大总结](https://blog.csdn.net/yefengzhichen/article/details/52372407)
* [二分查找专题（二）](https://blog.csdn.net/qq_21688757/article/details/53907379)
* [LeetCode Binary Search Summary 二分搜索法小结](http://www.cnblogs.com/grandyang/p/6854825.html)