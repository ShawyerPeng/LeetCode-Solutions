# 简介

# 适用场景
图论问题，如finding cycles in edge, largest components。
O(M) for union find, M operations
M quick union + path compression on N objects should be N + MlgN

应用: Undirected Graph 

# 分类
* make set
* union
* find set

Union-Find 的主要作用 (在 LeetCode 和遇到的 OA 中) 主要可以用于找到联通区域，或者找到集合在一起的类。  
通过 Union-Find, 当数字不断加入的时候，可以按照顺序，将他们聚合在一起。

聚合的方式是 int[son] = father, 对于 son 这个元素，他的值即是他指向的父亲节点。最终将会形成一个或者多个树结构的区块（树可能联通）

Union-Find 主要有两种方式构成，一种是 Quick - Find，另一种是 Quick - Union。  
这两种方法之间有 trade-off，想要查找快，那么 union 这个过程可能较慢。想要 union 快，那么 find 就会较慢。

## Quick - Find
简而言之，就是查找快，这样形成的树一般深度为 2，查找某个数，和其根很快。但是每次加入新节点的时候，需要的时间较长。  
这个一般不常用，基本做题没遇到过。

## Quick - Union
一般都是用这个，然后再加入压缩路径的算法

# 思路
* for n nodes from 0 to n-1, create roots[n] to track each root's parents.  
    -- initialize parent with -1(point to null), roots = [-1,-1,-1,...-1],  
    eg: n nodes from 0 to n-1, edges[0,1] [0,2] [2,3] will be [1,2,3,-1...]  
        -- recursively find root1 and root2 (edge[root1,root2])check if they are in the same set  
* if found in two sets, then union: `roots[root1] = root2`;  
    -- middle roots can be dirty, keep updating&maintain top parents or boundaries.  
    -- use path compression(point child root directly to top parent) to save time  
               


# 代码模板
```java
class UnionFind {
    private int count = 0;
    private int[] parent, rank;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        count--;
    }
    
    public int count() {
        return count;
    }
}

class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int m = M.length;
        int count = m;
        int[] union = new int[m];
        for (int i = 0; i < m; i++) union[i] = i;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                if (M[i][j] == 1) {
                    int root = findUnion(union, j);
                    int rootself = findUnion(union, i);
                    union[rootself] = root;
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(findUnion(union, i));
        }
        return set.size();
    }
    
    public int findUnion(int[] union, int id) {
        while (id != union[id]) {
            union[id] = union[union[id]];
            id = union[id];
        }
        return id;
    }
}
```

模板解释: 开始的时候，让所有节点的父亲节点指向自己

findUnion 中，可以让每个节点的父亲，指向自己的爷爷，这样会使得最后形成的树更短，之后的搜索也会更快。

# 相关题目
* [Friend Circles](https://leetcode.com/problems/friend-circles)
* [Surrounded Regions](https://leetcode.com/problems/surrounded-regions)
* [128. Longest Consecutive Sequence]()
* [261. Graph Valid Tree]()
* [323. Number of Connected Components in an Undirected Graph]()
* [305. Number of Islands II](https://leetcode.com/problems/number-of-islands-ii)

# 参考资料
[并查集详解 (转)](http://blog.csdn.net/dellaserss/article/details/7724401)  
[傻子都能看懂的并查集入门](https://segmentfault.com/a/1190000004023326)  
[并查集的简单介绍](http://skyhigh233.com/blog/2017/04/02/union-find/)  
[Leetcode 总结之 Union Find](http://www.cnblogs.com/zmyvszk/p/5351494.html)  
[【LC 总结】Union Find 系列 (Num of Islands I&II/Graph Valid Tree/etc)](https://segmentfault.com/a/1190000007010346)  
[Union Findi 的模板](http://52.14.116.56/2017/09/15/LeetCode/LeetCode-Union-Find/)  
[Leetcode - Union Find](https://yijiajin.github.io/leetcode/2017/01/03/Leetcode-Union-Find/)  
[Surrounded Regions 并查集解法的问题 - 九章算法](https://www.jiuzhang.com/qa/1460/)  
[Union Find 并查集](http://hongzheng.me/union-find/)  
