# 简介


# 适用范围
* Permutations
* Permutations II
* Next Permutation
* Permutation Sequence
* Subsets
* Subsets II
* Combinations
* Combinations Sum II
* Word Break II
* Palindrome Partitioning
* Path Sum II
* Restore IP Addresses
* Substring with Concatenation of All Words
* Letter Combinations of a Phone Number

# 不适用范围
实际为数学问题，没有技巧性
* Permutation Sequence
* Next Permutation

# 排列组合总结
* `Arrays.sort()`：去重
* `res.add()`：什么时候输出结果
* `if (condition) continue`：什么情况跳过

基本题，但是非常重要。面试中碰到任何一题一点也不奇怪。PIE,CC150和Leetcode都不约而同地包含了这类题。把这些题目做熟是必须的。
基本上来说这类题的解法都是DFS，程序的大体框架非常类似，只是根据题目的要求代码稍作修改。当然每道题也有不同的解法，但是你应该根据自己的喜好把这类题目的解决方案统一化。
熟悉了这类题目以后对于DFS(will be discussed in a separate section)的理解会非常深刻。基本上一般的DFS的题目应该没什么问题了。

无论是排列还是组合，这类题都有一个变形，就是要求不能有重复的输出。PIE和CC150都没有提到相应的解法，大家应该很好的体会一下。如果没有相应的准备，属于面试的时候比较容易跪的题目。

# 参考资料
[Leetcode backtracking 模板解法小结](http://www.daandu.com/2017/08/04/leetcode-backtracking-%E6%A8%A1%E6%9D%BF%E8%A7%A3%E6%B3%95%E5%B0%8F%E7%BB%93/)  
[[算法题] Combinations 和 Subset 时间复杂度比较 [Leetcode]](http://www.1point3acres.com/bbs/thread-117602-1-1.html)  
