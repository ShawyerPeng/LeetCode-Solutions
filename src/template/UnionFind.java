package template;

import java.util.HashMap;
import java.util.HashSet;

public class UnionFind {
    HashMap<Integer, Integer> father = new HashMap();
    // 初始化
    UnionFind(HashSet<Integer> hashSet) {
        for (Integer now : hashSet) {
            father.put(now, now);
        }
    }

    // O(n)复杂度的find
    public int find(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        return parent;
    }

    // O(1)复杂度的find
    public int compressedFind(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        // 这里parent是他的最大祖先。那么，包括他以及中间的各种都直接设置为指道最大祖先。
        int temp = -1;
        int xFa = x;
        while (xFa != father.get(xFa)) {
            temp = father.get(xFa); // 因为要把xFa的祖先设置为最大祖先了，所以，得先把踏上一级father记录下来。
            father.put(xFa, parent);
            xFa = temp;
        }
        return parent;
    }

    // x，y有一条边。所以，如果他们的祖先不一样，那么就把他们随便谁和谁连起来
    public void union(int x, int y) {
        int xFa = compressedFind(x);
        int yFa = compressedFind(y);
        if (xFa != yFa) {
            father.put(xFa, yFa);
        }
    }

    public static void main(String[] args) {

    }
}
