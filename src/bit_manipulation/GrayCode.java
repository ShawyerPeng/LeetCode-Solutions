package bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < (1 << n); ++i)
            results.add(i ^ (i >> 1));
        return results;
    }

    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        System.out.println(obj.grayCode(2));
    }
}
