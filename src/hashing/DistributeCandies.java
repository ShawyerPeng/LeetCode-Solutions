package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/distribute-candies
 * 题目：把一堆数字平均分成两堆，其中的一堆的最大的种类个数为多少。
 *
 * 思路：HashMap，统计每个数字出现的次数，然后统计就行。
 * 如果种类的数目多于总数字的半数，那么只能选半数的，否则不能平均分成两堆，否则就可以选择种类的个数做最多的分类个数。
 */
public class DistributeCandies {
    public static int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for(int candy : candies){
            kinds.add(candy);
        }
        return Math.min(kinds.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        int[] candies = new int[]{1,1,2,2,3,3};
        System.out.println(distributeCandies(candies));
    }
}
// http://blog.csdn.net/fuxuemingzhu/article/details/71412550