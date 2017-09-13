# 简介
* BFS：二叉树上的宽搜、图上的宽搜（拓扑排序）、棋盘上的宽搜
* DFS：用于搜索, 题目中有 ALL 字样
* 二分法：用于时间复杂度小于 O(n) 的情
* 分治法：二叉树问题, 子问题和父问题有关系


# BFS
## 使用场景
1. 图的遍历 Traversal in Graph
* 层级遍历 Level Order Traversal: 有先碰到后碰到的问题, 分距离远近
– 由点及面 Connected Component: 联通问题, 比如 Smallest Rectangle Enclosing Black Pixels 这道题就可以用灌水法做: 二分法 O(Row * logCol + Col * LogRow), 灌水法 O(R * C)- 拓扑排序 Topological Sorting: 有向图 

2. 最短路径 Shortest Path in Simple Graph
* 仅限简单图求最短路径 (图中每条边长度都是 1, 且没有方向)
ps: 如果问最长的路径呢? 用 DP 或者 dfs 所有路径找一遍



# DFS




# 选择
一般来讲可以用 dfs 的问题也能用 bfs 来解决，然后因为 dfs 容易爆栈，而队列比较容易控制，所以一般可以用 bfs
但两者实际的优缺点还是要看具体的题目的，
比如剪枝，因为 bfs 和 dfs 的搜索顺序是有区别的，所以在相同剪枝下的速度会不一样，因此我们可以考虑怎么样的顺序是可以快速搜到解 (考虑解的稀疏程度, 在搜索树上的位置什么的)，这个就要看具体的题目了。
一般来说，bfs 用在寻找最短路径的问题多一些，dfs 用在快速发现底部节点的相关问题多一些


# 参考资料
[Depth First Search 拾遗](http://blog.hyoung.me/cn/2017/03/depth-first-search/)  
[leetcode 中学习 recursion](http://vlsi1217.github.io/2015/02/16/Leetcode/LeetcodeRecursion/)  
[宽度优先搜索 Breadth First Search](https://stomachache007.wordpress.com/2017/03/20/nc4-md/)  
