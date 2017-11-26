package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency
 * 问题：给定一个字符串，将字符按照出现次数倒序排列
 * 思路：字符统计 + 排序
 * 先统计每个字符的数量，然后将这些字符连同频率放入一个优先队列中，再取出来即可．
 * 这种时间复杂度为 O(n) + O(m log m)，其中 n 为字符串长度，m 为不同字符的个数，在最坏情况下时间复杂度为 O(n log n)，即所有字符都不一样
 * 还有一种可以优化的方法，在统计完字符频率之后利用类似与计数排序的方法，开一个 n+1 长度大小的数组，将不同的频率字符放到频率的索引处．
 * 然后从高到低取得所有字符串．这种方法的好处是在最环情况下依然可以保证时间复杂度为 O(n)
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 先统计出每个字符出现的个数
        for (Character ch : s.toCharArray()) {
            // 次数加1
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 自定义排序规则
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            // return (x < y) ? -1 : ((x == y) ? 0 : 1);
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    //public static String frequencySortPriorityQueue(String s) {
    //    Map<Character, Integer> map = new HashMap<>();
    //    // 先统计出每个字符出现的个数
    //    for (Character ch : s.toCharArray()) {
    //        // 次数加1
    //        map.put(ch, map.getOrDefault(ch, 0) + 1);
    //    }
    //
    //    PriorityQueue<HashMap> pq = new PriorityQueue<>();
    //
    //    Iterator it = map.entrySet().iterator();
    //    while (it.hasNext()) {
    //        Map.Entry entry = (Map.Entry) it.next();
    //        pq.add(new HashMap()entry.g)
    //    }
    //}

    public static String frequencySort3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 先统计出每个字符出现的个数
        for (Character ch : s.toCharArray()) {
            // 次数加1
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 开一个 n+1 长度大小的数组，将不同的频率字符放到频率的索引处。
        List<Character> list = new ArrayList<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getValue() + " " + entry.getKey());
            // 由于ArrayList的限制，出现次数为1的字符存放在0的位置
            list.add((Integer) entry.getValue() - 1, (Character) entry.getKey());
        }

        // 然后从高到低取得所有字符串
        StringBuffer sb = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
// http://blog.csdn.net/qq508618087/article/details/53125359
// http://www.cnblogs.com/grandyang/p/6231504.html