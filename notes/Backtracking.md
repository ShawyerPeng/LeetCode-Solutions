# 简介
通常，我们将回溯法和 DFS 等同看待，可以用一个等式表示它们的关系：**回溯法 = DFS + 剪枝**。  
所以回溯法是 DFS 的延伸，其目的在於通過剪枝使得在深度優先搜索過程中如果滿足瞭回溯條件不必找到葉子節點，就截斷這一條路徑，從而加速 DFS。實際上，即使沒有剪枝，DFS 在從下層回退到上層的時候也是一個回溯的過程，通常這個時候某些變量的狀態。DFS 通常用遞歸的形式實現比較直觀，也可以用非遞歸，但通常需要借組輔助的數據結構（比如棧）來存儲搜索路徑。

回溯法可以被认为是一个有过剪枝的 DFS 过程。从初始状态出发，如果搜索到满足条件的状态，返回或者加入结果集合。  
回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就 “回溯” 返回，尝试别的路径。

回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为 “回溯点”。

许多复杂的，规模较大的问题都可以使用回溯法，有 “通用解题方法” 的美称。

优点：结构简洁  
缺点：效率低，可能栈溢出

# 思想


# 实现步骤
1. 确定所给问题的**解空间**：首先应明确定义问题的解空间，解空间中至少包含问题的一个解。
2. 确定结点的**扩展搜索规则**
3. 以**深度优先方式**搜索解空间，并在搜索过程中用**剪枝**函数避免无效搜索。

在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。
当探索到某一结点时，要先判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）
若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。
常常出现在求所有组合或者排列的题目中，思路往往比较固定。**

# 关键点
* 怎样去保存一个结点，即如何去定义问题状态
* 如何判断当前结点解的可能性：是中间结点，还是叶子结点（可行解或者不可达）
* 如何保存根结点到叶子结点的路径
* 如何回退到父结点

# 回溯问题类型
* Find a path to success 有没有解
* Find all paths to success 求所有解
    * 求所有解的个数
    * 求所有解的具体信息
* Find the best path to success 求最优解

关于回溯的三种问题，模板略有不同：
第一种，返回值是 true/false。  
第二种，求个数，设全局 counter，返回值是 void；求所有解信息，设 result，返回值 void。  
第三种，设个全局变量 best，返回值是 void。

第一类：
```java
boolean solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, return true
        else return false
    } else {
        for each child c of n {
            if solve(c) succeeds, return true
        }
        return false
    }
}
```

第二种：
```java
void solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, count++, return;
        else return
    } else {
        for each child c of n {
            solve(c)
        }
    }
}
```

第三种：
```java
void solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, update best result, return;
        else return
    } else {
        for each child c of n {
            solve(c)
        }
    }
}
```


# 代码模板
递归的一般结构：
```java
void dfs() {
    if(符合边界条件) {
       // 边界条件处理，记录或输出结果
       return;
    }
     
    // 某种形式的调用
    dfs();
}
```

回溯的一般结构：
```java
void dfs(int 当前状态) {
    if (当前状态为边界状态) {    // 当前结点为可行解
        // 边界条件处理，记录或输出结果
        results.add(path);      // 保存该解
        return;
    }
    // 当前结点为中间结点
    for (i = 0; i = n; i++) {
        // 扩展出一个子状态
        // 修改了全局变量
        if (子状态满足约束条件) {
            dfs(子状态)
        }
        // 回溯部分，恢复全局变量
    }
}
```

BFS的一般结构：
```java
// 将首节点加入队列
q.push(head);
// 标记首节点已经被访问
isvisited[head]=true;   
while(!q.empty()) {
    // 访问temp，并标记temp已被访问过
    int temp = q.poll();
    // 将 temp 的子相关节点加入队列
    q.push(temp 相关节点);
}
```


# 题目类型
* Subset
    * [Subsets](https://leetcode.com/problems/subsets)：返回所有子数组，原数组无重复
    * [Subsets II](https://leetcode.com/problems/subsets-ii)：返回所有子数组，原数组有重复
    这个题可以作为所有递归求解搜索问题的模板，这种题就是定义一种 helper 函数来进行递归。也没什么好多说的，反正就是每次递增一下状态，在 subset 这个题目中状态就是当前搜索到了第几个元素，以及当前的字符串是什么样子的。在 subset II 中稍微有点复杂的就是去重，实际上只需要在 for 循环里面加个 if 条件判断就行了。
* Permutation
    * [Permutations](https://leetcode.com/problems/permutations)：求一组数字的全排列
    * [Permutations II](https://leetcode.com/problems/permutations-ii)：给定的一组数字有重复，并且要求结果集中不能有重复的组合
    这个题的状态就是把 set 中每一个元素加入一个集合，然后当集合长度等于输入数组的长度时就可以加入结果集合了。这题的第二个也是去重的问题，这里就需要一个额外的数组来判断先前的元素有没有被放入过结果。这题里面有一些剪枝还是值得想一下，没有这些剪枝这题过不了。
* Combination
    * [Combination sum](https://leetcode.com/problems/combination-sum)：给定一组数字和一个 target 值，求所有和等于 target 的组合（组合中每个数字可以出现多次）
    * [Combination sum II](https://leetcode.com/problems/combination-sum-ii)：组合中每个数字只能出现一次
    * [Combination Sum III](https://leetcode.com/problems/combination-sum-iii)：给定元素个数从 1-9 中选取指定元素，求等于目标值的排列组合
    * [Combinations](https://leetcode.com/problems/combinations)
* N-Queens
    * [N-Queens](https://leetcode.com/problems/n-queens)：返回 N 格子中 N 个棋子不能毗邻的所有解法
    * [N-Queens II](https://leetcode.com/problems/n-queens-ii)：同上，返回所有解法的数量
* [Generate Parentheses](https://leetcode.com/problems/generate-parentheses)：求所有 n 对括号 "()" 组成的字符串
* [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning)：返回所有回文的切分
* [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)：给出电话号码，求电话号码对应的所有字符串
* [Sudoku Solver](https://leetcode.com/problems/sudoku-solver)：数独解

# 小结
* 做搜索的题目，最关键的是要知道对什么对象进行 dfs，例如，在 sudoku 中是对每一个以 “.” 标记的方格进行 dfs，在回文划分中，是对每一个划分的位置进行 dfs，在 8 妃问题中，是对每一行妃子可以在的位置进行 dfs。  
其次，dfs 时，我们需要判断所取的每一个解是否是有效的，最好写一个函数来专门做这件事情。只要当当前对象 dfs 的数值有效时，才会继续往对下一个对象进行 dfs，否则就直接向上回溯了（这点可以参见 sudoku 中的解释）。  
最后，对于每次 dfs 时，可以对范围进行分支限界。例如回文划分、subset 等。
* 值得注意的是：到底要对多少对象进行 dfs，有时候是很明显的，例如 8 妃和 sudoku 问题，8 妃就是对 8 行依次 dfs，sudoku 就是对所有方格进行 dfs。但有时，总共要对多少对象进行 dfs 并不明显。dfs 的递归基要处理的就是 dfs 完多少个对象就一定要返回（不然就无限 dfs 下去了）。当然，在 sudoku 问题中，方格的循环走完返回，这是一个隐含的递归基。  
总结：dfs 函数中，递归基处理的是 dfs 多少个对象就要返回。而每次 dfs 的 for 循环，往往是每一次 dfs 的范围。当递归栈最顶层的那个 dfs 循环走完，搜素就完成了。
* 在图论中，往往是从某一个点开始往下 dfs，dfs 的范围是当前 node 的所有 neighbor，与我们通常的搜索问题不同的是，图论中的 dfs 在回溯时不会剪枝，总之，找到一条路径就结束了。
* 
* 
* 

# 参考资料
[算法笔记：DFS+Backtracking 系列](http://www.jianshu.com/p/11ad5ce0daad)  
[Backtracking](https://github.com/xuelangZF/LeetCode/tree/master/Backtracking)  
[[Leetcode] Backtracking 回溯法 (又称 DFS, 递归) 全解](https://segmentfault.com/a/1190000006121957)  
[演算法筆記 - Backtracking](http://www.csie.ntnu.edu.tw/~u91029/Backtracking.html)  
[全面解析回溯法：算法框架与问题求解](http://www.cnblogs.com/wuyuegb2312/p/3273337.html)  
[Subsets - 子集](http://www.code123.cc/docs/leetcode-notes/backtracking/subsets.html)  
[算法技巧 - backtracking](http://summerisgreen.com/blog/2017-07-07-2017-07-07-%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7-backtracking.html)  
[什么时候需要回溯？](https://www.jiuzhang.com/qa/5162/)  
[回溯法解决组合问题](https://deadend.me/2016/07/12/solve-combination-problems-using-backtracking/)  
[[算法专题] 深度优先搜索 & 回溯剪枝](https://my.oschina.net/abcijkxyz/blog/722700)  
[LeetCode 55 Jump Game 从回溯到动态规划](http://www.wangjialong.cc/2017/09/29/leetcode55/)  
[Leetcode 中回溯问题总结 (Java)](http://lyz1052.github.io/2017/09/07/%E7%AE%97%E6%B3%95/Leetcode%20%E4%B8%AD%E5%9B%9E%E6%BA%AF%E9%97%AE%E9%A2%98%E6%80%BB%E7%BB%93%20(Java)/)  
[LeetCode-A series of Combination Sum](http://wangzaozao.top/2017/11/02/LeetCode39/)  
[LeetCode 解题报告 (37)-- 回溯法解决数独问题](http://wulc.me/2016/04/15/LeetCode%E8%A7%A3%E9%A2%98%E6%8A%A5%E5%91%8A(37)--%E5%9B%9E%E6%BA%AF%E6%B3%95%E8%A7%A3%E5%86%B3%E6%95%B0%E7%8B%AC/)  
[Leetcode 分类解析：组合算法](http://dev.dafan.info/detail/134762)  
[A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partioning)](https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning)  
[LeetCode 算法面试分类解法 Recurion-and-Backstracking](http://www.thpffcj.com/2017/10/06/LeetCode-Recurion-and-Backstracking/)  
[递归如何转换为非递归](http://veaxen.com/?p=231)  
[树 - 前中后序遍历的非递归实现](http://www.tamarous.com/2017/10/10/several-ways-of-travel-tree/)  
