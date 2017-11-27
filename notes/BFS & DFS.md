# 简介
* BFS(迭代方法 (Iterative Solution))：二叉树上的宽搜、图上的宽搜（拓扑排序）、棋盘上的宽搜
* DFS(递归方法 (Recursive Solution)：)：用于搜索, 题目中有 ALL 字样
* 二分法：用于时间复杂度小于 O(n) 的情
* 分治法：二叉树问题, 子问题和父问题有关系


# BFS
## 适用场景
1. 图的遍历 Traversal in Graph
* 层级遍历 Level Order Traversal: 有先碰到后碰到的问题, 分距离远近
– 由点及面 Connected Component: 联通问题, 比如 Smallest Rectangle Enclosing Black Pixels 这道题就可以用灌水法做: 二分法 O(Row * logCol + Col * LogRow), 灌水法 O(R * C)- 拓扑排序 Topological Sorting: 有向图 

2. 最短路径 Shortest Path in Simple Graph
* 仅限简单图求最短路径 (图中每条边长度都是 1, 且没有方向)
ps: 如果问最长的路径呢? 用 DP 或者 dfs 所有路径找一遍

3. 计算图的连通性、单源最短路径、计算最小操作次数等

## 代码模板
需要一个队列，用于一层一层扩展，一个 hashset，用于判重，一棵树（只求长度时不需
要），用于存储整棵树。
对于队列，可以用 queue，也可以把 vector 当做队列使用。当求长度时，有两种做法：
1. 只用一个队列，但在状态结构体 state_t 里增加一个整数字段 step，表示走到当前状态用
了多少步，当碰到目标状态，直接输出 step 即可。这个方案，可以很方便的变成 A* 算法，
把队列换成优先队列即可。
2. 用两个队列，current, next，分别表示当前层次和下一层，另设一个全局整数 level，表
示层数（也即路径长度），当碰到目标状态，输出 level 即可。这个方案，状态可以少一个字
段，节省内存。
对于 hashset，如果有完美哈希方案，用布尔数组 `bool visited[STATE_MAX]` 或 `vector<bool> visited(STATE_MAX, false)` 来表示；如果没有，可以用 STL 里的 set 或 unordered_set。
对于树，如果用 STL，可以用 u`nordered_map<state_t, state_t> father` 表示一颗树，代码非常简洁。如果能够预估状态总数的上限（设为 STATE_MAX），可以用数组 `state_t nodes[STATE_-MAX]`，即树的双亲表示法来表示树，效率更高，当然，需要写更多代码。

## 复杂度
时间复杂度：大部分 BFS 问题的时间复杂度都是 `O(V+E)`（V 表示顶点数，E 表示有向图中边的条数）。因为每个元素访问一次，元素之间的边，也称之为联系，也访问一次。所以是这个复杂度。
Knight Shortest Path， Zombie in Matrix 两题都是如此。

当然有非常特殊的情况，比如你访问到一个节点的时候，这个节点你需要处理其他的步骤，那么时间复杂度就要算上。

空间复杂度为 O(V)。

# DFS
## 使用场景
对链状图，BFS 最好（队列中最多只有 1 个元素），DFS 最差（所有节点都在根节点的递归内）。  
对起点与其他所有点相邻的图，DFS 最好（递归深度为 1），BFS 最差（队列中放满了所有与起点相邻的图）。

## 代码模板






# 选择
一般来讲可以用 dfs 的问题也能用 bfs 来解决，然后因为 dfs 容易爆栈，而队列比较容易控制，所以一般可以用 bfs
但两者实际的优缺点还是要看具体的题目的，
比如剪枝，因为 bfs 和 dfs 的搜索顺序是有区别的，所以在相同剪枝下的速度会不一样，因此我们可以考虑怎么样的顺序是可以快速搜到解 (考虑解的稀疏程度, 在搜索树上的位置什么的)，这个就要看具体的题目了。
一般来说，bfs 用在寻找最短路径的问题多一些，dfs 用在快速发现底部节点的相关问题多一些


# 参考资料
[Depth First Search 拾遗](http://blog.hyoung.me/cn/2017/03/depth-first-search/)  
[leetcode 中学习 recursion](http://vlsi1217.github.io/2015/02/16/Leetcode/LeetcodeRecursion/)  
[宽度优先搜索 Breadth First Search](https://stomachache007.wordpress.com/2017/03/20/nc4-md/)  
[LeetCode 中 Tree 的 BFS](http://leetcodesummary.blogspot.com/2013/10/leetcode-treebfs.html)  
[LeetCode 之 Breadth-first Search 题目汇总](https://www.zybuluo.com/Yano/note/255729)  
[关于 Leetcode 上二叉树的算法总结](http://www.cnblogs.com/whc-uestc/p/4729606.html)  
[复杂度计算：[刷题笔记] LeetCode 261/LintCode 178 - Graph Valid Tree](http://blog.leanote.com/post/westcode/277e1e29337e)  
[算法笔记：DFS+Backtracking 系列](http://www.jianshu.com/p/11ad5ce0daad)  
[DFS 模板](https://maogm.com/blog/dfs-template.html)  
[递归，回溯，DFS，BFS 的理解和模板](http://chen-tao.github.io/2017/01/27/al-template/)  
[『leetcode』递归 / DFS](https://www.hrwhisper.me/leetcode-recursive-or-dfs/)  
