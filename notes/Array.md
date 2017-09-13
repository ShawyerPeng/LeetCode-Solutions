# Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

给定一个整数数组，和一个目标数值，要求找出数组中相加等于目标数值的两个数，以数组形式返回它们的下标（假定每组输入有且只有一组符合条件的解，返回结果不能是同一元素）

## 暴力穷举
```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

## Two-pass Hash Table
用空间换时间。时间复杂度 O(n)，空间复杂度 O(n)。
使用哈希表存储已遍历过的数字。
```java
public int[] twoSum(int[] nums, int target) {
    //  利用 HashMap，把 target-numbers[i] 的值放入 HashMap 中
    Map<Integer, Integer> map = new HashMap<>();
    // 第一次迭代，把每个元素的值存入HashMap，key为元素值，value为元素索引
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    // 第二次迭代，判断target-numbers[i]是否存在于HashMap中
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        // 互补数(target-nums[i])不能是nums[i]它本身
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```


## One-pass Hash Table
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        // 用目标数去减当前数，如果所得依然在数组中，那就得到结果
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

## 二分查找法
这道题不能像传统二分查找法那样舍弃一半在另外一半查找，需要一点点挪 low 和 high 指针，所以时间复杂度为 O(n)。

首先先将整个 list 拷贝并排序，使用 Arrays.Sort() 函数，时间复杂度 O(nlogn) 
然后利用二分查找法，判断 target 和 numbers[low]+numbers[high]。
target == numbers[low]+numbers[high]， 记录 copy[low] 和 copy[high]；
target > numbers[low]+numbers[high]，说明最大的和最小的加一起还小于 target，所以小值要取大一点，即 low++；

target > numbers[low]+numbers[high], 说明最大的和最小的加一起大于 target，那么大值需要往下取一点，即 high--。

再把找到的两个合格值在原 list 中找到对应的 index，返回即可。 

总共的时间复杂度为 O(n+nlogn+n+n) = O(nlogn)。
```java
public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    if (nums == null || nums.length < 2)
        return res;

    // 复制原始数组并排序
    int[] copylist = new int[nums.length];
    System.arraycopy(nums, 0, copylist, 0, nums.length);
    Arrays.sort(copylist);

    // 设置 low 和 high 指针
    int low = 0;
    int high = copylist.length - 1;

    // 二分查找法，判断 target 和 nums[low]+nums[high]哪个大
    while (low < high) {
        if (copylist[low] + copylist[high] < target)
            low++;
        else if (copylist[low] + copylist[high] > target)
            high--;
        else {
            res[0] = copylist[low];
            res[1] = copylist[high];
            break;
        }
    }

    // 把找到的两个合格值在原 list 中找到对应的 index
    int index1 = -1, index2 = -1;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == res[0] && index1 == -1)
            index1 = i + 1;
        else if (nums[i] == res[1] && index2 == -1)
            index2 = i + 1;
    }
    res[0] = index1;
    res[1] = index2;
    Arrays.sort(res);
    return res;
}
```

# 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

给一个n个整数的数组S，求任意三个元素a,b,c之和为0的情况（不重复）。
## 暴力穷举
```java

```

## 二分查找法
3 Sum是two Sum的变种，可以利用two sum的二分查找法来解决问题。

我们可以先排序 O(nlogn)，我们知道 2Sum 是选定两指针从前后分别向中间扫，找到能找到就直接返回。与 2Sum 不同的是，3Sum 要先选定一个数，再按照 2Sum 的思路找另两个数，即使找到了，也得继续找下去，不能直接返回。同时，要注意去重：
```java

```


# 4Sum
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


```java

```

```java

```

```java

```