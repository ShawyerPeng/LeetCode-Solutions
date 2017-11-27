package binary_search;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters
 * 问题：给定房屋和加热器的位置(在同一水平线)，求加热器的最小半径使得所有房屋都能被这些加热器覆盖
 * 先将取暖器数组排序，再遍历所有 house，对每个 house，在取暖器数组中进行 binary search
 * 如果命中，则说明取暖器位置和 house 位置重合，这个 house 的最小半径为 0；
 * 如果没有命中，则使用返回的 index，将 index 左边和右边的取暖器坐标与 house 坐标求差值，找出这个 house 最小半径.
 *
 * 升序排列加热器的坐标heaters
 * 遍历房屋houses，记当前房屋坐标为house：
 * 利用二分查找，分别找到不大于house的最大加热器坐标left，以及不小于house的最小加热器坐标right
 * 则当前房屋所需的最小加热器半径radius = min(house - left, right - house)
 * 利用radius更新最终答案ans
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                //index = -(index + 1);
                index = ~index;
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Heaters obj = new Heaters();
        System.out.println(obj.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(obj.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }
}
