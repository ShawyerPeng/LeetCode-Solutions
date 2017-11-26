package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 * 问题：常数时间内插入、删除、获得随机数
 * 思路：哈希表 + 数组 （HashMap + Array），利用数组存储元素，利用哈希表维护元素在数组中的下标
 * 哈希表的新增 / 删除操作是 O(1)，而数组的随机访问操作开销也是 O(1)
 * 利用到了一个一维数组和一个哈希表，其中数组用来保存数字，哈希表用来建立每个数字和其在数组中的位置之间的映射
 * 对于插入操作，我们先看这个数字是否已经在哈希表中存在，如果存在的话直接返回 false，不存在的话，我们将其插入到数组的末尾，然后建立数字和其位置的映射。
 * 删除操作是比较 tricky 的，我们还是要先判断其是否在哈希表里，如果没有，直接返回 false。
 * 由于哈希表的删除是常数时间的，而数组并不是，为了使数组删除也能常数级，我们实际上将要删除的数字和数组的最后一个数字调换个位置，然后修改对应的哈希表中的值
 * 这样我们只需要删除数组的最后一个元素即可，保证了常数时间内的删除。
 * 而返回随机数对于数组来说就很简单了，我们只要随机生成一个位置，返回该位置上的数字即可
 */
public class InsertDeleteGetRandomO1 {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static List<Integer> list = new ArrayList<>();
    private static Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int removedIndex = map.get(val);
        map.remove(val);
        if (removedIndex < list.size() - 1) {
            int tail = list.get(list.size() - 1);
            list.set(removedIndex, tail);
            map.put(tail, removedIndex);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 obj = new InsertDeleteGetRandomO1();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(2));
        System.out.println(obj.getRandom());
    }
}
// http://www.jianshu.com/p/a9c2987cd51d
// http://www.cnblogs.com/grandyang/p/5740864.html