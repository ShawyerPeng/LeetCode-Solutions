# 简介
## 使用场景
动态规划常常适用于具有重复子问题（overlapping subproblems）和最优子结构（optimal substructure）特点的问题，所耗时间往往远少于朴素解法。

重复子问题是指在用递归算法自顶向下对问题进行求解时，每次产生的子问题并不总是新问题，有些子问题会被重复计算多次。动态规划法利用了这种子问题的重复性质，对每一个子问题只计算一次，将其结果记忆化存储，以便下次需要同一个子问题解时直接查表，从而获得较高的效率。

最优子结构性质是指问题的最优解由相关子问题的最优解组合而成，一个问题的最优解所包含的子问题的解也是最优的。动态规划只能应用于有最优子结构的问题。

此外，动态规划还有无后效性。即子问题的解一旦确定，就不再改变，不受在这之后、包含它的更大的问题的求解决策影响。

* 满足以下条件之一：
    * Maximum/Minimum
    * Yes/No
    * Count(*)（如果要把所有方案列出来，一定不是动态规划）
* 不能sort/swap

## 四个要素
* 状态定义：存储小规模问题的结果
* 状态转移方程：状态之间的联系，怎么通过小的状态，来算大的状态
* 初始化：最极限的小状态是什么
    * 自顶向下：起点
    * 自底向上：终点
* 结果：最大的那个状态是什么
    * 自顶向下：起点
    * 自底向上：终点

## 常见题型
1. Matrix DP (10%)
2. Sequence (40%)
3. Two Sequences DP (40%)
4. Backpack (10%)

### Matrix DP
state：`f[x][y]`表示我从起点走到坐标x,y……
function：研究走到x,y这个点之前的一步
intialize：起点
answer：终点

碰到二维dp问题，初始化就要考虑`dp[0][0]`、`dp[i][0]`、`dp[0][j]`三个状态
* `dp[0][0] = nums[0][0]`
* `dp[i][0] = sum(0, 0->i, 0)`
* `dp[0][j] = sum(0, 0->0, j)`


### Sequence
初始化：
对长度为n的字符串往往开辟n+1的空间，把0留出来，那么答案就是`dp[s.length()]`



#### LIS
我们维护一个一维 dp 数组，其中 dp[i] 表示以 nums[i] 为结尾的最长递增子串的长度，对于每一个 nums[i]，我们从第一个数再搜索到 i，如果发现某个数小于 nums[i]，我们更新 dp[i]，更新方法为 dp[i] = max(dp[i], dp[j] + 1)，即比较当前 dp[i] 的值和那个小于 num[i] 的数的 dp 值加 1 的大小，我们就这样不断的更新 dp 数组，到最后 dp 数组中最大的值就是我们要返回的 LIS 的长度
```java
public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int n = nums.length;
    int[] dp = new int[n];

    dp[0] = 1;
    int max = 0;

    for (int i = 1; i < n; i++) {
        int maxval = 0;
        for (int j = 1; j < i; j++) {
            if (nums[j] < nums[i]) {
                // dp[i]表示前i个数字中以第i个结尾的LIS的长度
                maxval = Math.max(maxval, dp[j]);
            }
        }
        // 当前字符串能接在前j个元素的
        dp[i] = maxval + 1;
        max = Math.max(max, dp[i]);
    }
    return max;
}
```








## 分类
动态规划有两种基本思路，一种是自顶而下的备忘录算法，一种思路是自底向上的动态规划算法。

* 自顶向下：将问题划分为若干子问题，求解这些子问题并保存结果以免重复计算，该方法将递归和缓存结合在一起。
* 自底向上：先行求解所有可能用到的子问题，然后用其构造更大问题的解。


## 自底向上
自底向上就是已经知道了所有递归边界，把所有可能的状态都算出来。基本步骤是一个拓扑排序的过程，从所有递归边界出发，当一个状态被所有可能的下层状态更新后，就用这个状态去更新后面的状态。直到所求的状态被彻底更新完成为止。

这段话，说成人话就是：从初始已知的状态出发，向外拓展，最后到达目标状态。

## 自顶向下
自顶向下就是不考虑整个图结构，直接从要求的状态开始展开式子，如果式子中的某个状态的值还不清楚，就递归的从这个状态展开。递归结束后式子中的状态都被对应的值替换了，所求状态自然也就清楚了。

说成人话就是：从最终状态开始，找到可以到达当前状态的状态，如果该状态还没处理，就先处理该状态。

自顶向下通常使用递归实现，自顶向下的动态规划通常又有另外一个形象名字，叫做 “记忆化搜索”。因为我们会去保存那个状态。

## 区别
大多时候用自顶向下复杂度会更低，因为可以过滤掉更多无用的状态；不过自底向上可以避免爆栈问题，而且实现往往实现更为简单。










Traverse
Divide & Conquer

```java
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        dfs(0, 0);
    }

    static void dfs(int x, int y, int sum) {
        if (x == n) {
            if (sum < best) {
                best = sum;
            }
            return;
        }
        dfs(x + 1, y, sum + a[x][y]);
        dfs(x + 1, y + 1, sum + a[x][y]);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Triangle.minimumTotal(triangle);
    }
}
```

# Decode Ways
```java

```

#
```java

```

```java

```

```java

```

```java

```

```java

```