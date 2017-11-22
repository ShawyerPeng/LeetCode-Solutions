package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists
 */
public class MinimumIndexSumOfTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = Integer.MAX_VALUE;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        ArrayList<String> results = new ArrayList<>();
        int count = 0;
        for (String str : list1) {
            map1.put(str, count);
            count++;
        }
        count = 0;
        for (String str : list2) {
            map2.put(str, count);
            count++;
        }

        Iterator it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (map2.containsKey(entry.getKey())) {
                int indexSum = (Integer) entry.getValue() + map2.get(entry.getKey());
                if (indexSum == minIndexSum) {
                    // 如果minIndexSum = indexSum，那么将这个字符串加入结果 results 中
                    minIndexSum = indexSum;
                    results.add((String) entry.getKey());
                } else if (indexSum < minIndexSum) {
                    // 如果比 minIndexSum 小，那么 minIndexSum 更新为这个较小值 indexSum，然后将结果 results 清空并加入这个字符串
                    minIndexSum = indexSum;
                    results.clear();
                    results.add((String) entry.getKey());
                }
            }
        }

        int size = results.size();
        return results.toArray(new String[size]);
    }

    public static void main(String[] args) {
        //String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        //String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        //String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        //String[] list2 = new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"};
        String[] list1 = new String[]{"k","KFC"};
        String[] list2 = new String[]{"k","KFC"};
        String[] results = findRestaurant(list1, list2);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
// http://www.cnblogs.com/grandyang/p/6978646.html