//package binary_search;
//
///**
// * https://leetcode.com/problems/guess-number-higher-or-lower
// * 问题：
// * 思路：
// */
//public class GuessNumberHigherOrLower {
//    public int guessNumber(int n) {
//        int start = 0;
//        int end = n;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            // 数字大了，应该选个小点的
//            if (guess(mid) == 1)
//                start = mid + 1;
//            // 数字小了，应该选个大点的
//            else if (guess(mid) == -1)
//                end = mid - 1;
//            else
//                return mid;
//        }
//
//        return end;
//    }
//}
