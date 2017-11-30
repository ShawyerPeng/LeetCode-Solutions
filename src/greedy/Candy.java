package greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy
 * 问题：
 * 思路：典型的贪心算法题本身可以用贪心法来做，我们用 candy[n] 表示每个孩子的糖果数
 * 遍历过程中，如果孩子 i+1 的 rate 大于孩子 i 的 rate，那么当前最好的选择自然是：给孩子 i+1 的糖果数 = 给孩子 i 的糖果数 + 1
 * 如果孩子 i+1 的 rate 小于等于孩子 i 的 rate 咋整？这个时候就不大好办了，因为我们不知道当前最好的选择是给孩子 i+1 多少糖果。
 */
public class Candy {
    /**
     * 用candy[n]表示每个孩子的糖果数，遍历过程中，
     * 如果孩子i+1的rate大于孩子i 的rate，那么当前最好的选择自然是：给孩子i+1的糖果数=给孩子i的糖果数+1
     * 如果孩子i+1的rate小于等于孩子i 的rate咋整？这个时候就不大好办了，因为我们不知道当前最好的选择是给孩子i+1多少糖果。
     * 解决方法是：暂时不处理这种情况。等数组遍历完了，我们再一次从尾到头遍历数组，
     * 这回逆过来贪心，就可以处理之前略过的孩子。
     * 最后累加candy[n]即得到最小糖果数。
     **/
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 0)
            return 0;

        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && num[i] < num[i + 1] + 1)
                num[i] = num[i + 1] + 1;
        }

        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];
        return sum;
    }

    public static void main(String[] args) {
        Candy obj = new Candy();
        System.out.println(obj.candy(new int[]{1,7,5,2,6,4,2,3}));
    }
}
